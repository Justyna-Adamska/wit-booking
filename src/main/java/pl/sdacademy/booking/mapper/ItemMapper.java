package pl.sdacademy.booking.mapper;

import pl.sdacademy.booking.data.ItemAttributeEntity;
import pl.sdacademy.booking.data.ItemEntity;
import pl.sdacademy.booking.model.ItemDto;

import java.util.HashSet;
import java.util.Set;

public class ItemMapper {
    public static ItemDto mapToItemDto(ItemEntity entity) {
        if (entity == null) {
            return null;
        }

        Set<String> attributes = mapAttributes(entity.getAttributes());
        String name = (entity.getName() != null && !entity.getName().isEmpty()) ? entity.getName() : null;

        return ItemDto.builder()
                .id(entity.getId())
                .name(name)
                .price(entity.getPrice())
                .description(entity.getDescription())
                .attributes(attributes)
                .build();
    }
    private static Set<String> mapAttributes(Set<ItemAttributeEntity> itemAttributeEntities) {
        Set<String> result = new HashSet<>();
        for (ItemAttributeEntity attributeEntity : itemAttributeEntities) {
            result.add(attributeEntity.getAttributeName());
        }
        return result;
    }
}

