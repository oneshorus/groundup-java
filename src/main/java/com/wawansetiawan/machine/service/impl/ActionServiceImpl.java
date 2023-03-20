package com.wawansetiawan.machine.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wawansetiawan.machine.entity.ActionEntity;
import com.wawansetiawan.machine.repository.ActionRepository;
import com.wawansetiawan.machine.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {
    
    private final ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public List<ActionEntity> findAll() {
        return actionRepository.findAll();
    }

    @Override
    public ActionEntity findById(Long id) {
        return actionRepository.findById(id).orElse(null);
    }
}
