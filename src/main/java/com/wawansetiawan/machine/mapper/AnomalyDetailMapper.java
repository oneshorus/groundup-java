package com.wawansetiawan.machine.mapper;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.wawansetiawan.machine.dto.AnomalyDto;
import com.wawansetiawan.machine.entity.AnomalyEntity;

@Component
public class AnomalyDetailMapper {
    
    public Optional<AnomalyDto> toDto(AnomalyEntity anomalyEntity) {
        if (anomalyEntity == null) {
            return null;
        }

        AnomalyDto anomalyDto = new AnomalyDto();

        anomalyDto.setId(String.format("%08d", anomalyEntity.getId()));
        anomalyDto.setTimestamp(anomalyEntity.getTimestamp());
        anomalyDto.setPath(anomalyEntity.getPath());
        anomalyDto.setSensorId(anomalyEntity.getSensorId());

        if (anomalyEntity.getMachineTypeEntity() != null) {
            anomalyDto.setMachineType(anomalyEntity.getMachineTypeEntity().getName());
            anomalyDto.setMachineTypeId(anomalyEntity.getMachineTypeEntity().getId());
        }

        if (anomalyEntity.getAnomalyReasonEntity() != null) {
            anomalyDto.setAnomalyReason(anomalyEntity.getAnomalyReasonEntity().getId());
        }

        if (anomalyEntity.getActionEntity() != null) {
            anomalyDto.setAction(anomalyEntity.getActionEntity().getId());
        }

        if (anomalyEntity.getComment() != null) {
            anomalyDto.setComment(anomalyEntity.getComment());
        }

        return Optional.ofNullable(anomalyDto);
    }
}
