package com.wawansetiawan.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wawansetiawan.machine.entity.MachineTypeEntity;

public interface MachineTypeRepository extends JpaRepository<MachineTypeEntity, Long>{

}
