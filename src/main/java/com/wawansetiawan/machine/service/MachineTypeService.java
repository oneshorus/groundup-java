package com.wawansetiawan.machine.service;

import java.util.List;
import java.util.Optional;

import com.wawansetiawan.machine.entity.MachineTypeEntity;

public interface MachineTypeService {
    List<MachineTypeEntity> findAll();
    Optional<MachineTypeEntity> findById(Long id);
}
