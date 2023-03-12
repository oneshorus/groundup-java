package com.wawansetiawan.machine.service;

import java.util.List;
import java.util.Optional;

import com.wawansetiawan.machine.entity.ActionEntity;

public interface ActionService {
    List<ActionEntity> findAll();
    Optional<ActionEntity> findById(Long id);
}
