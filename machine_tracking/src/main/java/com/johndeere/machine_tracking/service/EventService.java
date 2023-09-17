package com.johndeere.machine_tracking.service;

import com.johndeere.machine_tracking.model.Event;
import com.johndeere.machine_tracking.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(String sessionId, Instant eventAt, String eventType, double numericEventValue) {
        Event event = new Event(sessionId, eventAt, eventType, numericEventValue);
        return eventRepository.save(event);
    }
}

