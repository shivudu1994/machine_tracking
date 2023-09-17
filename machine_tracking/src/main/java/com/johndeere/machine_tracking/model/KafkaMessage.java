package com.johndeere.machine_tracking.model;

import java.time.Instant;

public class KafkaMessage {
    private String sessionId;
    private String machineId;
    private Instant startAt;
    private Instant eventAt; // Single event timestamp
    private String eventType;
    private double numericEventValue;

    public KafkaMessage() {
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

    public Instant getEventAt() {
        return eventAt;
    }

    public void setEventAt(Instant eventAt) {
        this.eventAt = eventAt;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public double getNumericEventValue() {
        return numericEventValue;
    }

    public void setNumericEventValue(double numericEventValue) {
        this.numericEventValue = numericEventValue;
    }
}
