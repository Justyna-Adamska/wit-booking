package pl.sdacademy.booking.mapper;

import org.junit.jupiter.api.Test;
import pl.sdacademy.booking.data.ItemAttributeEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.model.ItemDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {

    @Test
    void shouldMapItemEntitiesToItemDtos() {
        Set<ItemAttributeEntity> attributes = new HashSet<>();
        ItemAttributeEntity attribute1 = new ItemAttributeEntity();
        attribute1.setId(1L);
        attribute1.setAttributeName("twarz");
        attributes.add(attribute1);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1L);
        itemEntity.setName("Pierwszy");
        itemEntity.setDescription("opis");
        itemEntity.setPrice(BigDecimal.valueOf(120.0));
        itemEntity.setAttributes(attributes);


        ItemDto itemDto = ItemMapper.mapToItemDto(itemEntity);

        assertThat(itemDto).isNotNull();
        assertThat(itemDto.getId()).isEqualTo(1L);
        assertThat(itemDto.getName()).isEqualTo("Pierwszy");
        assertThat(itemDto.getDescription()).isEqualTo("opis");
        assertThat(itemDto.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(120.0));
        assertThat(itemDto.getAttributes()).containsExactly("twarz");
    }

    @Test
    void shouldMapNullItemEntityToNullItemDto() {

        ItemDto itemDto = ItemMapper.mapToItemDto(null);

        assertThat(itemDto).isNull();
    }

    @Test
    void shouldMapItemEntityWithEmptyNameToItemDtoWithNullName() {

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1L);
        itemEntity.setName(" ");
        itemEntity.setDescription("opis");
        itemEntity.setPrice(BigDecimal.valueOf(120.0));


        ItemDto itemDto = ItemMapper.mapToItemDto(itemEntity);


        assertThat(itemDto).isNotNull();
        assertThat(itemDto.getName()).isEqualTo(" ");
    }
}