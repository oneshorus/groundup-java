package com.wawansetiawan.machine.mapper;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.wawansetiawan.machine.dto.AnomalyListDto;
import com.wawansetiawan.machine.entity.AnomalyEntity;

@Component
public class AnomalyMapper {

    public List<AnomalyListDto> toDto(List<AnomalyEntity> entities) {

        List<AnomalyListDto> dtos = new ArrayList<>();
        for (AnomalyEntity entity : entities) {

            AnomalyListDto dto = new AnomalyListDto();
            dto.setId(String.format("%08d", entity.getId()));
            dto.setTimestamp(entity.getTimestamp());

            if (entity.getAnomalyReasonEntity() != null) {
                dto.setAnomalyReason(entity.getAnomalyReasonEntity().getId());
            }

            if (entity.getMachineTypeEntity() != null) {
                dto.setMachineType(entity.getMachineTypeEntity().getId());
            }

            if (entity.getAnomalyLevelEntity() != null) {
                dto.setAnomalyLevel(entity.getAnomalyLevelEntity().getId());
            }
            
            dtos.add(dto);
        }
        return dtos;
    }
    
    // public AnomalyEntity toEntity(AnomalyListDto dto) {
    //     AnomalyEntity entity = new AnomalyEntity();
    //     entity.setId(dto.getId());
    //     entity.setName(dto.getName());
    //     return entity;
    // }
}
