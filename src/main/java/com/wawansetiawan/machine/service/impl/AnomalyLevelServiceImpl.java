package com.wawansetiawan.machine.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wawansetiawan.machine.entity.AnomalyLevelEntity;
import com.wawansetiawan.machine.repository.AnomalyLevelRepository;
import com.wawansetiawan.machine.service.AnomalyLevelService;

@Service
public class AnomalyLevelServiceImpl implements AnomalyLevelService {
    
    private final AnomalyLevelRepository anomalyLevelRepository;

    public AnomalyLevelServiceImpl(AnomalyLevelRepository anomalyLevelRepository) {
        this.anomalyLevelRepository = anomalyLevelRepository;
    }

    @Override
    public List<AnomalyLevelEntity> findAll() {
        return anomalyLevelRepository.findAll();
    }

    @Override
    public Optional<AnomalyLevelEntity> findById(Long id) {
        return anomalyLevelRepository.findById(id);
    }
}
