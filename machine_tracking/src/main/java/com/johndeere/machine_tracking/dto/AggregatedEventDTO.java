package com.johndeere.machine_tracking.dto;

public class AggregatedEventDTO {
    private String eventType;
    private double aggregatedNumericEventValue;

    public AggregatedEventDTO() {
    }

    public AggregatedEventDTO(String eventType, double aggregatedNumericEventValue) {
        this.eventType = eventType;
        this.aggregatedNumericEventValue = aggregatedNumericEventValue;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public double getAggregatedNumericEventValue() {
        return aggregatedNumericEventValue;
    }

    public void setAggregatedNumericEventValue(double aggregatedNumericEventValue) {
        this.aggregatedNumericEventValue = aggregatedNumericEventValue;
    }
}
