package com.johndeere.machine_tracking.service;

import com.johndeere.machine_tracking.dto.AggregatedEventDTO;
import com.johndeere.machine_tracking.model.Event;

import java.time.Instant;
import java.util.List;

public interface EventService {
    Event createEvent(String sessionId, Instant eventAt, String eventType, double numericEventValue);

    List<AggregatedEventDTO> getAggregatedEventsBySessionId(String sessionId);
    List<AggregatedEventDTO> getAggregatedEventsByMachineId(String sessionId);
}
