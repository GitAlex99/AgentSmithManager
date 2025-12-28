package com.smith.manager.controller;

import com.smith.manager.response.FailedEventResponse;
import com.smith.manager.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    @GetMapping("/failedEvent")
    public List<FailedEventResponse> getEvent(@RequestParam(required = false) List<Long> ids){
        logger.info("Starting get event api");

        List<FailedEventResponse> response = managerService.getFailedEvent(ids);

        return response;
    }

}
