package com.smith.manager.controller;

import com.smith.manager.response.EventResponse;
import com.smith.manager.response.FailedEventResponse;
import com.smith.manager.response.TechnicalFailureResponse;
import com.smith.manager.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/v1/event")
public class ManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    @GetMapping("/failedEvent")
    public List<FailedEventResponse> getFailedEvent(@RequestParam(required = false) List<Long> ids){
        logger.info("Starting get failed event api");

        List<FailedEventResponse> response = managerService.getFailedEvent(ids);

        logger.info("Ending get failed event api");

        return response;
    }

    @GetMapping()
    public List<EventResponse> getEvent(@RequestParam(required = false) List<Long> ids,
                                        @RequestParam(required = false) List<String> topics,
                                        @RequestParam(required = false) long offsetFrom,
                                        @RequestParam(required = false) long offsetTo,
                                        @RequestParam(required = false) Timestamp sentAtFrom,
                                        @RequestParam(required = false) Timestamp sentAtTo){
        logger.info("Starting get event api");

        List<EventResponse> response = managerService.getEvent(
                ids,
                topics,
                offsetFrom,
                offsetTo,
                sentAtFrom,
                sentAtTo
        );

        logger.info("Ending get event api");

        return response;
    }

    @GetMapping("/technicalFailure")
    public List<TechnicalFailureResponse> getTechnicalFailure(){
        logger.info("Starting get technical failure api");

        List<TechnicalFailureResponse> response = managerService.getTechnicalFailure();

        logger.info("Ending get technical failure api");

        return response;
    }
}
