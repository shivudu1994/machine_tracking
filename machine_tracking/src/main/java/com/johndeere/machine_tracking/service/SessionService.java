package com.johndeere.machine_tracking.service;

import com.johndeere.machine_tracking.model.Event;
import com.johndeere.machine_tracking.model.MachineSession;
import com.johndeere.machine_tracking.repository.MachineSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SessionService {

    private final MachineSessionRepository machineSessionRepository;

    @Autowired
    public SessionService(MachineSessionRepository machineSessionRepository) {
        this.machineSessionRepository = machineSessionRepository;
    }

    public MachineSession createSession(String sessionId, String machineId, Instant StartAt) {
        MachineSession session = new MachineSession();
        session.setSessionId(sessionId);
        session.setMachineId(machineId);
        session.setStartAt(StartAt);

        return machineSessionRepository.save(session);
    }

    public boolean doesSessionExist(String sessionId) {
        return machineSessionRepository.existsById(sessionId);
    }

    public void closePreviousSession(String machineId) {
        MachineSession previousSession = machineSessionRepository.findOpenSessionByMachineId(machineId);

        if (previousSession != null) {
            previousSession.setEndAt(Instant.now());
            machineSessionRepository.save(previousSession);
        }
    }

}
