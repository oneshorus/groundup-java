package com.wawansetiawan.machine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wawansetiawan.machine.response.ApiResponse;

@RestController
@RequestMapping
public class UndefinedController {
    
    private static final String ErrorMessage = "failed";
    private static final String ErrorRequestMessage = "Invalid Request!";

    private static final Logger logger = LoggerFactory.getLogger(UndefinedController.class);

    @RequestMapping("/**")
    public ApiResponse handleUndefinedRequest() {
        logger.warn("Handling invalid request");

        ApiResponse apiResponse = new ApiResponse(ErrorMessage, null, ErrorRequestMessage);
        return apiResponse;
    }
}
