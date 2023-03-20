package com.wawansetiawan.machine.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wawansetiawan.machine.entity.AnomalyEntity;
import com.wawansetiawan.machine.repository.AnomalyRepository;
import com.wawansetiawan.machine.service.AnomalyService;
import com.wawansetiawan.machine.dto.AnomalyListDto;
import com.wawansetiawan.machine.dto.AnomalyDto;
import com.wawansetiawan.machine.mapper.AnomalyMapper;
import com.wawansetiawan.machine.mapper.AnomalyDetailMapper;

@Service
public class AnomalyServiceImpl implements AnomalyService {

    private static final String SeenStatusField = "seenStatus";
    private static final String TimestampField = "timestamp";
    
    private final AnomalyRepository anomalyRepository;

    @Autowired
    private AnomalyMapper anomalyMapper;

    @Autowired
    private AnomalyDetailMapper anomalyDetailMapper;

    public AnomalyServiceImpl(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    @Transactional
    @Override
    public List<AnomalyListDto> findAll() {
        return anomalyMapper.toDto(anomalyRepository.findAll(
            Sort.by(Sort.Direction.ASC, SeenStatusField).and(
                Sort.by(Sort.Direction.ASC, TimestampField)
            )
        ));
    }

    @Transactional
    @Override
    public Optional<AnomalyDto> findById(Long id) {
        AnomalyEntity anomalyEntity = anomalyRepository.findById(id).orElse(null);

        return anomalyDetailMapper.toDto(anomalyEntity);
    }

    @Transactional
    @Override
    public AnomalyEntity findEntityById(Long id) {
        AnomalyEntity anomalyEntity = anomalyRepository.findById(id).orElse(null);

        return anomalyEntity;
    }

    @Transactional
    @Override
    public Optional<AnomalyDto> updateAnomalyEntity(AnomalyEntity anomalyEntity) {
        AnomalyEntity updatedAnomalyEntity = anomalyRepository.save(anomalyEntity);

        return anomalyDetailMapper.toDto(updatedAnomalyEntity);
    }
}
