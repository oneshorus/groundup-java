package com.wawansetiawan.machine.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wawansetiawan.machine.entity.MachineTypeEntity;
import com.wawansetiawan.machine.repository.MachineTypeRepository;
import com.wawansetiawan.machine.service.MachineTypeService;

@Service
public class MachineTypeServiceImpl implements MachineTypeService {
    
    private final MachineTypeRepository machineTypeRepository;

    public MachineTypeServiceImpl(MachineTypeRepository machineTypeRepository) {
        this.machineTypeRepository = machineTypeRepository;
    }

    @Override
    public List<MachineTypeEntity> findAll() {
        return machineTypeRepository.findAll();
    }

    @Override
    public Optional<MachineTypeEntity> findById(Long id) {
        return machineTypeRepository.findById(id);
    }
}
