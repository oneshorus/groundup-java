package com.wawansetiawan.machine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wawansetiawan.machine.entity.AnomalyReasonEntity;

public interface AnomalyReasonRepository extends JpaRepository<AnomalyReasonEntity, Long>{
    
    List<AnomalyReasonEntity> findByMachineTypeEntityId(Long machineTypeId);
}
