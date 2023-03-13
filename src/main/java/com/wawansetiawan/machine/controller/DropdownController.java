package com.wawansetiawan.machine.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wawansetiawan.machine.service.MachineTypeService;
import com.wawansetiawan.machine.entity.MachineTypeEntity;
import com.wawansetiawan.machine.service.AnomalyReasonService;
import com.wawansetiawan.machine.service.ActionService;
import com.wawansetiawan.machine.service.AnomalyLevelService;
import com.wawansetiawan.machine.entity.ActionEntity;
import com.wawansetiawan.machine.entity.AnomalyLevelEntity;
import com.wawansetiawan.machine.response.ApiResponse;
import com.wawansetiawan.machine.dto.AnomalyReasonDto;

@RestController
@RequestMapping("/list")
public class DropdownController {

    private static final String SuccessMessage = "success";
    private static final String ErrorMessage = "failed";
    private static final String ErrorRequestMessage = "Invalid Request!";

    private static final Logger logger = LoggerFactory.getLogger(DropdownController.class);

    private final MachineTypeService machineTypeService;
    private final AnomalyReasonService anomalyReasonService;
    private final AnomalyLevelService anomalyLevelService;
    private final ActionService actionService;

    public DropdownController(MachineTypeService machineTypeService, AnomalyReasonService anomalyReasonService, AnomalyLevelService anomalyLevelService, ActionService actionService) {
        this.machineTypeService = machineTypeService;
        this.anomalyReasonService = anomalyReasonService;
        this.anomalyLevelService = anomalyLevelService;
        this.actionService = actionService;
    }

    @CrossOrigin
    @GetMapping("/machinetype")
    public ApiResponse findAllMachineType() {
        try {
            logger.info("Handling /list/machinetype request");

            List<MachineTypeEntity> data = machineTypeService.findAll();

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping("/anomalyreason")
    public ApiResponse findAllAnomalyReason() {
        try {
            logger.info("Handling /list/anomalyreason request");

            List<AnomalyReasonDto> data = anomalyReasonService.findAll();

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping("/anomalyLevel")
    public ApiResponse findAllAnomalyLevel() {
        try {
            logger.info("Handling /list/anomalyLevel request");

            List<AnomalyLevelEntity> data = anomalyLevelService.findAll();

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, e.getMessage());
        }
    }

    @CrossOrigin
    @GetMapping("/action")
    public ApiResponse findAllAction() {
        try {
            logger.info("Handling /list/action request");

            List<ActionEntity> data = actionService.findAll();

            return new ApiResponse(SuccessMessage, data, null);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return new ApiResponse(ErrorMessage, null, e.getMessage());
        }
    }

    @RequestMapping("/**")
    public ApiResponse handleUndefinedRequest() {

        logger.warn("Handling invalid request");

        ApiResponse apiResponse = new ApiResponse(ErrorMessage, null, ErrorRequestMessage);
        return apiResponse;
    }
}
