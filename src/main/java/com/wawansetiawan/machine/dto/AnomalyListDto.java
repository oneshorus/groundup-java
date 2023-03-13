package com.wawansetiawan.machine.dto;

import java.sql.Timestamp;

public class AnomalyListDto {
    private String id;
    private Timestamp timestamp;
    private Long anomalyReason;
    private Long machineType;
    private Long anomalyLevel;
    private Boolean seenStatus;

    // Getters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getAnomalyReason() {
        return anomalyReason;
    }

    public void setAnomalyReason(Long anomalyReason) {
        this.anomalyReason = anomalyReason;
    }

    public Long getMachineType() {
        return machineType;
    }

    public void setMachineType(Long machineType) {
        this.machineType = machineType;
    }

    public Long getAnomalyLevel() {
        return anomalyLevel;
    }

    public void setAnomalyLevel(Long anomalyLevel) {
        this.anomalyLevel = anomalyLevel;
    }

    public Boolean getSeenStatus() {
        return seenStatus;
    }

    public void setSeenStatus(Boolean seenStatus) {
        this.seenStatus = seenStatus;
    }
}
