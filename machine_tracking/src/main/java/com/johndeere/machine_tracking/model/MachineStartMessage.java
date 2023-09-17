package com.johndeere.machine_tracking.model;

import java.time.Instant;

public class MachineStartMessage {
    private String sessionId;
    private String machineId;
    private Instant startAt;

    public MachineStartMessage() {
    }

    public MachineStartMessage(String sessionId, String machineId, Instant startAt) {
        this.sessionId = sessionId;
        this.machineId = machineId;
        this.startAt = startAt;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public Instant getStartAt() {
        return startAt;
    }

    public void setStartAt(Instant startAt) {
        this.startAt = startAt;
    }
}
