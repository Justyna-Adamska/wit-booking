package pl.sdacademy.booking.service;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.model.EventDto;
import pl.sdacademy.booking.model.ItemDto;
import pl.sdacademy.booking.repository.EventRepository;
import pl.sdacademy.booking.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDto> findEvents() {
        log.info("findEvents");
        List<EventDto> result = new ArrayList<>();

        List<EventEntity> eventEntities = eventRepository.findAll();
        for (EventEntity entity : eventEntities) {

            result.add(EventDto.builder()
                    .name(entity.getItem().getName())
                    .price(entity.getItem().getPrice())
                    .fromTime(entity.getFrom())
                    .toTime(entity.getTo())
                    .build());
        }
        return result;
    }
}
