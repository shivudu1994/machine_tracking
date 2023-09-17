package com.johndeere.machine_tracking.listener;

import com.johndeere.machine_tracking.model.Event;
import com.johndeere.machine_tracking.model.KafkaMessage;
import com.johndeere.machine_tracking.service.SessionService;
import com.johndeere.machine_tracking.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class KafkaEventListener {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private EventService eventService;

    @KafkaListener(topics = "machine-data-topic", groupId = "machine-data-consumer")
    public void listenMachineData(KafkaMessage message) {
        if (message.getMachineId() != null && !message.getMachineId().isEmpty()) {
            processSessionMessage(message);
        } else if (sessionService.doesSessionExist(message.getSessionId()) && !message.getEvents().isEmpty()) {
            for (Event event : message.getEvents()) {
                Instant eventAt = event.getEventAt();
                createEvent(message.getSessionId(), eventAt, event.getEventType(), event.getNumericEventValue());
            }
        } else {
            System.out.println("There is an error in processing");
        }
    }


    private void processSessionMessage(KafkaMessage sessionMessage) {
        String sessionId = sessionMessage.getSessionId();
        String machineId = sessionMessage.getMachineId();
        Instant startAt = sessionMessage.getStartAt();

        if (!sessionService.doesSessionExist(sessionId)) {
            sessionService.createSession(sessionId, machineId, startAt);
        } else {
            sessionService.closePreviousSession(sessionId);
        }
    }

    private void createEvent(String sessionId, Instant eventAt, String eventType, double numericEventValue) {

        eventService.createEvent(sessionId, eventAt, eventType, numericEventValue);
    }
}
