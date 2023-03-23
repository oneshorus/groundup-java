package com.wawansetiawan.machine.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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

    private static final Logger logger = LoggerFactory.getLogger(AnomalyServiceImpl.class);
    
    private final AnomalyRepository anomalyRepository;

    @Autowired
    private AnomalyMapper anomalyMapper;

    @Autowired
    private AnomalyDetailMapper anomalyDetailMapper;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public AnomalyServiceImpl(AnomalyRepository anomalyRepository) {
        this.anomalyRepository = anomalyRepository;
    }

    @Override
    public List<AnomalyListDto> findAll() {
        return anomalyMapper.toDto(anomalyRepository.findAll(
            Sort.by(Sort.Direction.ASC, SeenStatusField).and(
                Sort.by(Sort.Direction.ASC, TimestampField)
            )
        ));
    }

    @Override
    public Optional<AnomalyDto> findById(Long id) {
        AnomalyEntity anomalyEntity = anomalyRepository.findById(id).orElse(null);

        return anomalyDetailMapper.toDto(anomalyEntity);
    }

    @Override
    @Transactional
    public AnomalyEntity findEntityById(Long id) {
        AnomalyEntity anomalyEntity = anomalyRepository.findById(id).orElse(null);

        return anomalyEntity;
    }

    @Override
    @Transactional
    public Optional<AnomalyDto> updateAnomalyEntity(AnomalyEntity anomalyEntity) {
        // AnomalyEntity updatedAnomalyEntity = anomalyRepository.save(anomalyEntity);

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            logger.info("Performing save entity!");
            // Perform some other database operation in a new transaction
            AnomalyEntity updatedAnomalyEntity = anomalyRepository.save(anomalyEntity);
            transactionManager.commit(status);

            return anomalyDetailMapper.toDto(updatedAnomalyEntity);
        } catch (Exception ex) {
            logger.info(ex.getLocalizedMessage());
            transactionManager.rollback(status);
            throw ex;
        }

        // return anomalyDetailMapper.toDto(updatedAnomalyEntity);
    }
}
