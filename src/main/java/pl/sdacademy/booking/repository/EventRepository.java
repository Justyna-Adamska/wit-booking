package pl.sdacademy.booking.repository;

import pl.sdacademy.booking.data.EventEntity;
import pl.sdacademy.booking.data.ItemEntity;

import java.util.List;

public interface EventRepository {


    List<EventEntity> findAll();


}

