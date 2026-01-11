package com.smith.manager.controller;

import com.smith.manager.response.EventResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

public class ManagerTechnicalController {

/*    @GetMapping()
    public List<EventResponse> getEvent(@RequestParam(required = false) List<Long> ids,
                                        @RequestParam(required = false) List<String> topics,
                                        @RequestParam(required = false) Long offsetFrom,
                                        @RequestParam(required = false) Long offsetTo,
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
    } */
}
