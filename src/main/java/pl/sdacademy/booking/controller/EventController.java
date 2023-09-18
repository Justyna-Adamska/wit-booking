package pl.sdacademy.booking.controller;

import pl.sdacademy.booking.repository.EventRepositoryImpl;
import pl.sdacademy.booking.repository.ItemRepositoryImpl;
import pl.sdacademy.booking.service.EventService;
import pl.sdacademy.booking.service.ItemService;

public class EventController {

    private final EventService eventService;

    public EventController() {
        this.eventService = new EventService(new EventRepositoryImpl());
    }

    public void presentEvents() {
        System.out.println("\n WIZYTY ");
        eventService.findEvents()
                .forEach(eventDto -> System.out.println(eventDto));
        System.out.println("\n KONIEC WIZYT ");
    }
}
