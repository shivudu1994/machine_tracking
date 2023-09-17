package com.johndeere.machine_tracking.listener;

import com.johndeere.machine_tracking.model.KafkaMessage;
import com.johndeere.machine_tracking.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.Instant;

@Service
public class KafkaEventListener {

    @Autowired
    private SessionService sessionService;

    @KafkaListener(topics = "machine-data-topic", groupId = "machine-data-consumer")
    public void listenMachineData(KafkaMessage message) {
        if (message.getMachineId() != null && !message.getMachineId().isEmpty()) {

            processSessionMessage(message);

        } else {
            System.out.println("Unrecognized message");
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


}
