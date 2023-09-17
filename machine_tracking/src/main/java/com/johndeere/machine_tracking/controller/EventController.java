
package com.johndeere.machine_tracking.controller;

import com.johndeere.machine_tracking.dto.AggregatedEventDTO;
import com.johndeere.machine_tracking.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/aggregated")
    public ResponseEntity<List<AggregatedEventDTO>> getAggregatedEvents(
            @RequestParam(required = false) String machineId,
            @RequestParam(required = false) String sessionId) {

        List<AggregatedEventDTO> aggregatedEvents;

        if (sessionId != null) {
            aggregatedEvents = eventService.getAggregatedEventsBySessionId(sessionId);
        } else if (machineId != null) {
            aggregatedEvents = eventService.getAggregatedEventsByMachineId(machineId);
        } else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(aggregatedEvents);
    }

}
