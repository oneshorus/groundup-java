package com.wawansetiawan.machine.mapper;

import java.util.Optional;
import java.sql.Clob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.wawansetiawan.machine.dto.AnomalyDto;
import com.wawansetiawan.machine.entity.AnomalyEntity;

@Component
public class AnomalyDetailMapper {
    
    private static final Logger logger = LoggerFactory.getLogger(AnomalyDetailMapper.class);

    public Optional<AnomalyDto> toDto(AnomalyEntity anomalyEntity) {
        if (anomalyEntity == null) {
            return null;
        }

        AnomalyDto anomalyDto = new AnomalyDto();

        anomalyDto.setId(String.format("%08d", anomalyEntity.getId()));
        anomalyDto.setTimestamp(anomalyEntity.getTimestamp());
        anomalyDto.setPath(anomalyEntity.getPath());

        if (anomalyEntity.getMachineTypeEntity() != null) {
            anomalyDto.setMachineType(anomalyEntity.getMachineTypeEntity().getName());
        }

        if (anomalyEntity.getAnomalyReasonEntity() != null) {
            anomalyDto.setAnomalyReason(anomalyEntity.getAnomalyReasonEntity().getId());
        }

        if (anomalyEntity.getActionEntity() != null) {
            anomalyDto.setAction(anomalyEntity.getActionEntity().getId());
        }

        if (anomalyEntity.getComment() != null) {
            Clob clob = anomalyEntity.getComment();
            try {
                if (clob != null) {
                    String comment = clob.getSubString(1, (int) clob.length());
        
                    anomalyDto.setComment(comment);
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }

        return Optional.ofNullable(anomalyDto);
    }
}
