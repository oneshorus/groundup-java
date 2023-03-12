package com.wawansetiawan.machine.service;

import java.util.List;
import java.util.Optional;

import com.wawansetiawan.machine.entity.AnomalyLevelEntity;

public interface AnomalyLevelService {
    List<AnomalyLevelEntity> findAll();
    Optional<AnomalyLevelEntity> findById(Long id);
}
