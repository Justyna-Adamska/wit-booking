package pl.sdacademy.booking.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class EventDto {


    private String name;
    private BigDecimal price;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;

    EventDto(String name, BigDecimal price, LocalDateTime fromTime, LocalDateTime toTime) {
        this.name = name;
        this.price = price;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }


}

