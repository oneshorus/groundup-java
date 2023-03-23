package com.wawansetiawan.machine.controller;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wawansetiawan.machine.service.ActionService;
import com.wawansetiawan.machine.service.AnomalyReasonService;
import com.wawansetiawan.machine.service.AnomalyService;
import com.wawansetiawan.machine.dto.AnomalyListDto;
import com.wawansetiawan.machine.entity.ActionEntity;
import com.wawansetiawan.machine.entity.AnomalyEntity;
import com.wawansetiawan.machine.entity.AnomalyReasonEntity;
import com.wawansetiawan.machine.dto.AnomalyDto;
import com.wawansetiawan.machine.response.ApiResponse;


@RestController
@RequestMapping("/anomaly")
public class AnomalyController {

    private static final String SuccessMessage = "success";
    private static final String ErrorMessage = "failed";
    private static final String ErrorServerMessage = "Internal Server Error!";
    private static final String ErrorRequestMessage = "Invalid Request!";
    private static final String ErrorNotFoundMessage = "Data not found!";

    private static final Logger logger = LoggerFactory.getLogger(AnomalyController.class);

    private final AnomalyService anomalyService;
    private final AnomalyReasonService anomalyReasonService;
    private final ActionService actionService;

    public AnomalyController(AnomalyService anomalyService, AnomalyReasonService anomalyReasonService, ActionService actionService) {
        this.anomalyService = anomalyService;
        this.anomalyReasonService = anomalyReasonService;
        this.actionService = actionService;
    }

    /* 
    * 
    * For TEST ONLY
    *
    *
    @GetMapping("/{machineTypeId}")
    public ApiResponse findAllAnomalyReasonByMachineTypeID(@PathVariable("machineTypeId") Long machineTypeId) {
        try {
            List<AnomalyReasonEntity> data = anomalyReasonService.findByMachineTypeEntityId(machineTypeId);

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            return new ApiResponse(ErrorMessage, null, e.getMessage());
        }
    }
    */

    @CrossOrigin
    @GetMapping
    public ApiResponse findAllAnomaly() {
        try {
            logger.info("Handling /anomaly request");

            List<AnomalyListDto> data = anomalyService.findAll();

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, ErrorServerMessage);
        }
    }

    @CrossOrigin
    @PostMapping("/{anomalyId}")
    public ApiResponse updateAnomaly(@PathVariable("anomalyId") Long anomalyId, @RequestBody AnomalyDto anomaly) {
        try {
            logger.info(String.format("Handling /anomaly/%d update", anomalyId));

            AnomalyEntity anomalyDB = anomalyService.findEntityById(anomalyId);
            if (anomalyDB == null) {
                return new ApiResponse(ErrorMessage, null, ErrorNotFoundMessage);
            }
            
            if (anomaly.getComment() != null && !anomaly.getComment().isEmpty()){
                anomalyDB.setComment(anomaly.getComment());
            }

            AnomalyReasonEntity reasonEntity = anomalyReasonService.findById(anomaly.getAnomalyReason());
            if (reasonEntity != null) {
                anomalyDB.setAnomalyReasonEntity(reasonEntity);
            }

            ActionEntity actionEntity = actionService.findById(anomaly.getAction()); 
            if (actionEntity != null) {
                anomalyDB.setActionEntity(actionEntity);
            }

            anomalyDB.setSeenStatus(true);

            Optional<AnomalyDto> data = anomalyService.updateAnomalyEntity(anomalyDB);

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, ErrorServerMessage);
        }
    }

    @CrossOrigin
    @GetMapping("/{anomalyId}")
    public ApiResponse findAnomalyDetail(@PathVariable("anomalyId") Long anomalyId) {
        try {
            logger.info(String.format("Handling /anomaly/%d request", anomalyId));

            Optional<AnomalyDto> data = anomalyService.findById(anomalyId);

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, ErrorServerMessage);
        }
    }

    @ExceptionHandler(NumberFormatException.class)
    public ApiResponse handleNumberFormatException(NumberFormatException e) {
        logger.error(e.getMessage());

        return new ApiResponse(ErrorMessage, null, ErrorRequestMessage);
    }

    @RequestMapping("/**")
    public ApiResponse handleUndefinedRequest() {

        logger.warn("Handling invalid request");

        ApiResponse apiResponse = new ApiResponse(ErrorMessage, null, ErrorRequestMessage);
        return apiResponse;
    }
}
