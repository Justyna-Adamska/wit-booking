package pl.sdacademy.booking.service;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.model.EventDto;
import pl.sdacademy.booking.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDto> findAllEvents() {
        log.info("findEvents");
        List<EventDto> result = new ArrayList<>();
        List<EventEntity> eventEntities = eventRepository.findAllEvents();
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

