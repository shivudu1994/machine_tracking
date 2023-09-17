
package com.johndeere.machine_tracking.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sessions_data")
public class SessionEvent {

    @Id
    @Column(name = "session_id")
    private String sessionId;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Event> events;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
