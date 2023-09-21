package pl.sdacademy.booking.model;

import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
public class NewItemDTO {
    private String name;
    private String description;
    private BigDecimal price;
}
