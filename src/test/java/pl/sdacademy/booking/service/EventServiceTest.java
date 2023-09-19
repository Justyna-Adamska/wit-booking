package pl.sdacademy.booking.service;

import org.junit.jupiter.api.Test;
import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.model.EventDto;
import pl.sdacademy.booking.repository.EventRepository;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


class EventServiceTest {
    private EventService sut;

    @Test
    void shouldResultAllItemsInDbAsListOfDto() {
        sut = new EventService(new EventServiceTest.TestEventRepository());

        List<EventDto> result = sut.findAllEvents();

        assertThat(result).hasSize(1);
        EventDto first = result.get(0);
        // liczba ponizszych asercji sygnalizuje, ze klasa moze miec za duzo odpowiedzialnosci
        // powinna zostac podzielona na bardziej specjalistyczne klasy
        assertThat(first.getId()).isEqualTo(1L);
        assertThat(first.getName()).isEqualTo("Usuwanie przebarwień twarz");
        assertThat(first.getPrice()).isEqualTo(BigDecimal.valueOf(130.0));
        assertThat(first.getFromTime()).isEqualTo(LocalDateTime.of(2023, Month.SEPTEMBER, 13, 12, 00, 00));
        assertThat(first.getToTime()).isEqualTo(LocalDateTime.of(2023, Month.SEPTEMBER, 13, 12, 50, 00));


    }

    public static class TestEventRepository implements EventRepository {

        @Override
        public List<EventEntity> findAllEvents() {


            ItemEntity first = new ItemEntity();
            first.setId(1l);
            first.setName("Usuwanie przebarwień twarz");

            first.setPrice(BigDecimal.valueOf(130.0));
            EventEntity pierwszy = new EventEntity();
            pierwszy.setItem(first);
            pierwszy.setFrom(LocalDateTime.of(2023, Month.SEPTEMBER, 13, 12, 00, 00));
            pierwszy.setTo(LocalDateTime.of(2023, Month.SEPTEMBER, 13, 12, 50, 00));
            return List.of(pierwszy);
        }

        @Override
        public void addEvent(EventEntity item) {

        }

        @Override
        public Long findEventsByDate(LocalDateTime date) {
            return null;
        }


    }


}