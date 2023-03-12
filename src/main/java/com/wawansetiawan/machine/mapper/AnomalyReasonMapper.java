package com.wawansetiawan.machine.mapper;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.wawansetiawan.machine.dto.AnomalyReasonDto;
import com.wawansetiawan.machine.entity.AnomalyReasonEntity;

@Component
public class AnomalyReasonMapper {
    
    public List<AnomalyReasonDto> toDto(List<AnomalyReasonEntity> reasons) {
        List<AnomalyReasonDto> dtos = new ArrayList<>();

        for (AnomalyReasonEntity reason : reasons) {
            AnomalyReasonDto dto = new AnomalyReasonDto();

            dto.setId(reason.getId());

            if (reason.getMachineType() != null) {
                dto.setMachineType(reason.getMachineType().getId());
            }

            dto.setReason(reason.getReason());

            dtos.add(dto);
        }

        return dtos;
    }
}
