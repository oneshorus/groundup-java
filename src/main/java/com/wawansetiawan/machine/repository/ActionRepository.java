package com.wawansetiawan.machine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wawansetiawan.machine.entity.ActionEntity;

public interface ActionRepository extends JpaRepository<ActionEntity, Long>{
    
}
