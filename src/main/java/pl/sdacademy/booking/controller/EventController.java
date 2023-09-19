package pl.sdacademy.booking.controller;

import pl.sdacademy.booking.repository.EventRepositoryImp;
import pl.sdacademy.booking.repository.ItemRepositoryImpl;
import pl.sdacademy.booking.service.EventService;
import pl.sdacademy.booking.service.ItemService;

public class EventController {

    private final EventService eventService;

    public EventController() {
        this.eventService = new EventService(new EventRepositoryImp());
    }

    public void presentEvents() {
        System.out.println("\n WIZYTY ");
        eventService.findAllEvents()
                .forEach(eventDto -> System.out.println(eventDto));
        System.out.println("\n KONIEC WIZYT ");
    }
}
