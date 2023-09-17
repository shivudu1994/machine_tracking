package com.johndeere.machine_tracking.service;

import com.johndeere.machine_tracking.dto.AggregatedEventDTO;
import com.johndeere.machine_tracking.model.Event;
import com.johndeere.machine_tracking.model.MachineSession;
import com.johndeere.machine_tracking.repository.EventRepository;
import com.johndeere.machine_tracking.repository.MachineSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final MachineSessionRepository sessionRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, MachineSessionRepository sessionRepository) {
        this.eventRepository = eventRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Event createEvent(String sessionId, Instant eventAt, String eventType, double numericEventValue) {
        Event event = new Event(sessionId, eventAt, eventType, numericEventValue);
        return eventRepository.save(event);
    }

    @Override
    public List<AggregatedEventDTO> getAggregatedEventsBySessionId(String sessionId) {
        List<Event> events = eventRepository.findBySessionId(sessionId);

        Map<String, Double> aggregatedData = events.stream()
                .collect(Collectors.groupingBy(Event::getEventType, Collectors.summingDouble(Event::getNumericEventValue)));

        return aggregatedData.entrySet().stream()
                .map(entry -> new AggregatedEventDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AggregatedEventDTO> getAggregatedEventsByMachineId(String machineId) {

        List<MachineSession> sessions = sessionRepository.findByMachineId(machineId);

        List<AggregatedEventDTO> aggregatedEvents = new ArrayList<>();

        for (MachineSession session : sessions) {
            List<AggregatedEventDTO> sessionAggregatedEvents = getAggregatedEventsBySessionId(session.getSessionId());
            aggregatedEvents.addAll(sessionAggregatedEvents);
        }

        Map<String, Double> aggregatedData = aggregatedEvents.stream()
                .collect(Collectors.groupingBy(AggregatedEventDTO::getEventType, Collectors.summingDouble(AggregatedEventDTO::getAggregatedNumericEventValue)));

        return aggregatedData.entrySet().stream()
                .map(entry -> new AggregatedEventDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
