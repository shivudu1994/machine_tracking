package com.johndeere.machinetracking.model;

import java.time.Instant;

public class SessionResponse {

    private String sessionId;
    private String machineId;
    private Instant startAt;
    private Instant endAt;
    private double totalNumericEventValue;

    public SessionResponse() {
        // Default constructor
    }

    public SessionResponse(String sessionId, String machineId, Instant startAt, Instant endAt) {
        this.sessionId = sessionId;
        this.machineId = machineId;
        this.startAt = startAt;
        this.endAt = endAt;
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

    public Instant getEndAt() {
        return endAt;
    }

    public void setEndAt(Instant endAt) {
        this.endAt = endAt;
    }

    public void setTotalNumericEventValue(double totalNumericEventValue) {
        this.totalNumericEventValue = totalNumericEventValue;
    }


}
