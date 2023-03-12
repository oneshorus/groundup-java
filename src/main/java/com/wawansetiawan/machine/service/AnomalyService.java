package com.wawansetiawan.machine.service;

import java.util.List;
import java.util.Optional;

import com.wawansetiawan.machine.dto.AnomalyListDto;
import com.wawansetiawan.machine.dto.AnomalyDto;

public interface AnomalyService {
    List<AnomalyListDto> findAll();
    Optional<AnomalyDto> findById(Long id);
}
