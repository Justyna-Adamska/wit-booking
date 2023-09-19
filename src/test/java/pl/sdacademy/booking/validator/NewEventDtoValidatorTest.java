package pl.sdacademy.booking.validator;

import org.junit.jupiter.api.Test;
import pl.sdacademy.booking.model.NewEventDto;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.List;

class NewEventDtoValidatorTest {
    @Test
    void shouldCheckThatFromIsNull() {
       NewEventDto input = NewEventDto.builder().itemName("przykad")
               .fromTime(null)
               .toTime(LocalDateTime.of(2023,9,19,19,56))
               .build();
        List<String> result = NewEventDtoValidator.validate(input);
        assertThat(result).hasSize(1).contains("From is null");

    }

    @Test
    void shouldCheckThatToIsNull() {
        NewEventDto input = NewEventDto.builder().itemName("przykad")
                .toTime(null)
                .fromTime(LocalDateTime.of(2023,9,19,19,56))
                .build();
        List<String> result = NewEventDtoValidator.validate(input);
        assertThat(result).hasSize(1).contains("To is null");

    }

    @Test
    void shouldCheckThatToAndFromIsNull() {
        NewEventDto input = NewEventDto.builder().itemName("przykad")
                .toTime(null)
                .fromTime(null)
                .build();
        List<String> result = NewEventDtoValidator.validate(input);
        assertThat(result).hasSize(2).contains("To is null");

    }
}