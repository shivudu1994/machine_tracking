package com.johndeere.machine_tracking.model;

import java.time.Instant;

public class KafkaMessage {
    private String sessionId;
    private Instant eventAt;
    private String eventType;
    private double numericEventValue;
    private MachineStartMessage machineStartMessage;

    public KafkaMessage() {
    }

    public KafkaMessage(String sessionId, Instant eventAt, String eventType, double numericEventValue, MachineStartMessage machineStartMessage) {
        this.sessionId = sessionId;
        this.eventAt = eventAt;
        this.eventType = eventType;
        this.numericEventValue = numericEventValue;
        this.machineStartMessage = machineStartMessage;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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

    public MachineStartMessage getMachineStartMessage() {
        return machineStartMessage;
    }

    public void setMachineStartMessage(MachineStartMessage machineStartMessage) {
        this.machineStartMessage = machineStartMessage;
    }
}


