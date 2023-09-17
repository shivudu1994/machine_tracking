package com.johndeere.machine_tracking.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "machine_sessions")
public class MachineSession {

    @Id
    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "machine_id", nullable = false)
    private String machineId;

    @Column(name = "start_at", nullable = false)
    private Instant startAt;

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
