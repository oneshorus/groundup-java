package com.wawansetiawan.machine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "anomaly_reason")
public class AnomalyReasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "machine_type_id")
    private MachineTypeEntity machineTypeEntity;

    private String reason;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MachineTypeEntity getMachineType() {
        return machineTypeEntity;
    }

    public String getReason() {
        return reason;
    }
}
