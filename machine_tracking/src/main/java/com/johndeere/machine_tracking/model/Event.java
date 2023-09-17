package com.johndeere.machine_tracking.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "events_data") // Specify the table name
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @Column(name = "event_at", nullable = false)
    private Instant eventAt;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "numeric_event_value", nullable = false)
    private double numericEventValue;

    public Event() {
    }

    public Event(String sessionId, Instant eventAt, String eventType, double numericEventValue) {
        this.sessionId = sessionId;
        this.eventAt = eventAt;
        this.eventType = eventType;
        this.numericEventValue = numericEventValue;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
}
