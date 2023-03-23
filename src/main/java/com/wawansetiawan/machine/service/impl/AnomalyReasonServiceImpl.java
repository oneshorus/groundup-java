package com.wawansetiawan.machine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wawansetiawan.machine.entity.AnomalyReasonEntity;
import com.wawansetiawan.machine.dto.AnomalyReasonDto;
import com.wawansetiawan.machine.mapper.AnomalyReasonMapper;

import com.wawansetiawan.machine.service.AnomalyReasonService;
import com.wawansetiawan.machine.repository.AnomalyReasonRepository;

@Service
public class AnomalyReasonServiceImpl implements AnomalyReasonService {
    
    private final AnomalyReasonRepository anomalyReasonRepository;

    @Autowired
    private AnomalyReasonMapper anomalyReasonMapper;

    public AnomalyReasonServiceImpl(AnomalyReasonRepository anomalyReasonRepository) {
        this.anomalyReasonRepository = anomalyReasonRepository;
    }

    @Override
    public List<AnomalyReasonEntity> findByMachineTypeEntityId(Long machineTypeId) {
        return anomalyReasonRepository.findByMachineTypeEntityId(machineTypeId);
    }

    @Override
    public List<AnomalyReasonDto> findAll() {
        return anomalyReasonMapper.toDto(anomalyReasonRepository.findAll());
    }

    @Override
    public AnomalyReasonEntity findById(Long id) {
        return anomalyReasonRepository.findById(id).orElse(null);
    }
}
