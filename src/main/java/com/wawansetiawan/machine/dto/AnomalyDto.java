package com.wawansetiawan.machine.dto;

import java.sql.Timestamp;

public class AnomalyDto {
    private String id;
    private Timestamp timestamp;
    private Long machineTypeId;
    private String machineType;
    // private Long anomalyLevel;
    private String sensorId;
    private String path;
    private Long anomalyReason;
    private Long action;
    private String comment;
    // private Boolean seenStatus;

    // Getters and Setters
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

    public Long getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(Long machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Long getAnomalyReason() {
        return anomalyReason;
    }

    public void setAnomalyReason(Long anomalyReason) {
        this.anomalyReason = anomalyReason;
    }

    public Long getAction() {
        return action;
    }

    public void setAction(Long action) {
        this.action = action;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
