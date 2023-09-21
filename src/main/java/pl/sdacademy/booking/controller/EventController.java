package pl.sdacademy.booking.controller;

import pl.sdacademy.booking.repository.EventRepositoryImp;
import pl.sdacademy.booking.repository.ItemRepository;
import pl.sdacademy.booking.repository.ItemRepositoryImpl;
import pl.sdacademy.booking.service.EventService;
import pl.sdacademy.booking.service.ItemService;

public class EventController {

    private final EventService eventService;

    public EventController() {
        // nienajlepsze rozwiazanie - skrot by moc zaprezentowac pseudo controller
        this.eventService = new EventService(new ItemRepositoryImpl(),new EventRepositoryImp());
    }

    public void presentEventSchedule() {
        System.out.println("\n ----- TERMINARZ SESJI ----- ");

        eventService.findAllEvents().forEach(System.out::println);

        System.out.println(" ----- KONIEC TERMINARZA SESJI ----- ");
    }
}
