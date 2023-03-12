package com.wawansetiawan.machine.service;

import java.util.List;
import java.util.Optional;

import com.wawansetiawan.machine.entity.AnomalyReasonEntity;
import com.wawansetiawan.machine.dto.AnomalyReasonDto;

public interface AnomalyReasonService {
    List<AnomalyReasonEntity> findByMachineTypeEntityId(Long machineTypeId);
    List<AnomalyReasonDto> findAll();
    Optional<AnomalyReasonEntity> findById(Long id);
}
