package com.wawansetiawan.machine.entity;

import java.sql.Clob;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "anomaly")
public class AnomalyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp timestamp;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "machine_type_id")
    private MachineTypeEntity machineTypeEntity;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anomaly_level_id")
    private AnomalyLevelEntity anomalyLevelEntity;

    private String sensorId;

    private String path;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anomaly_reason_id")
    private AnomalyReasonEntity anomalyReasonEntity;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
    private ActionEntity actionEntity;

    @Lob
    private Clob comment;

    private Boolean seenStatus;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public MachineTypeEntity getMachineTypeEntity() {
        return machineTypeEntity;
    }

    public AnomalyLevelEntity getAnomalyLevelEntity() {
        return anomalyLevelEntity;
    }
    
    public String getSensorId() {
        return sensorId;
    }
    
    public String getPath() {
        return path;
    }

    public AnomalyReasonEntity getAnomalyReasonEntity() {
        return anomalyReasonEntity;
    }

    public void setAnomalyReasonEntity(AnomalyReasonEntity anomalyReasonEntity) {
        this.anomalyReasonEntity = anomalyReasonEntity;
    }

    public ActionEntity getActionEntity() {
        return actionEntity;
    }

    public void setActionEntity(ActionEntity actionEntity) {
        this.actionEntity = actionEntity;
    }

    public Clob getComment() {
        return comment;
    }

    public void setComment(Clob comment) {
        this.comment = comment;
    }

    public Boolean getSeenStatus() {
        return seenStatus;
    }

    public void setSeenStatus(Boolean seenStatus) {
        this.seenStatus = seenStatus;
    }
}
