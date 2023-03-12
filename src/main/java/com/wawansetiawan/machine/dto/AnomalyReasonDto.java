package com.wawansetiawan.machine.dto;

public class AnomalyReasonDto {
    private Long id;
    private Long machineType;
    private String reason;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMachineType() {
        return machineType;
    }

    public void setMachineType(Long machineType) {
        this.machineType = machineType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
