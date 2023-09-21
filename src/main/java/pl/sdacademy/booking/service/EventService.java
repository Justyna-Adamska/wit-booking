package pl.sdacademy.booking.service;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.data.ItemEntity;
//import pl.sdacademy.booking.mapper.EventDtoMapper;
import pl.sdacademy.booking.mapper.EventDtoMapper;
import pl.sdacademy.booking.model.EventDto;
import pl.sdacademy.booking.model.NewEventDto;
import pl.sdacademy.booking.repository.EventRepository;
import pl.sdacademy.booking.repository.ItemRepository;
import pl.sdacademy.booking.util.TimeNow;
import pl.sdacademy.booking.validator.NewEventDtoValidator;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class EventService {
    
    private final ItemRepository itemRepository;


    private final EventRepository eventRepository;



    public EventService(ItemRepository itemRepository, EventRepository eventRepository) {
        this.itemRepository = itemRepository;
        this.eventRepository = eventRepository;
    }

//    public EventService(EventRepositoryImp eventRepository) {
//    }

    public List<EventDto> findAllEvents() {
        log.info("findEvents");
        List<EventDto> result = new ArrayList<>();
        List<EventEntity> eventEntities = eventRepository.findAllEvents();
        for (EventEntity entity : eventEntities) {
           result.add(EventDtoMapper.mapToEventDto(entity));

        }
        return result;
    }

    public String addEvent(NewEventDto newEvent) {
//        Long eventsByName = eventRepository.findEventsByDate(newEvent.getFromTime());
//        if (eventsByName != null) {
//            return "Sesja już istnieje.";
//        }

        List<String> validate = NewEventDtoValidator.validate(newEvent,new TimeNow());
        if (validate.size() != 0){
           String message = String.join(", ",validate);
           return message;
        }

        EventEntity eventEntity = new EventEntity();
        Long itemByName = itemRepository.findItemByName(newEvent.getItemName());//szukamy primary key

        if (itemByName == null || itemByName == -1L) {
            return "Nie znaleziono takiego obiektu";
        }

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId((itemByName));


        //tutaj bedzie wyszukiwanie id_itemu po jego nazwie - być może można wykorzystać metode repostitory Item findbyName
        //eventEntity.setItem(itemId)
        eventEntity.setItem(itemEntity); //przekazujemy primary key
        eventEntity.setFrom(newEvent.getFromTime());
        eventEntity.setTo(newEvent.getToTime());
        eventRepository.addEvent(eventEntity);
        return "Sesja została zapisana";
    }
    }

