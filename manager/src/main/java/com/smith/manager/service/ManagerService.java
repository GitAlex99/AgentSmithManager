package com.smith.manager.service;

import com.smith.manager.DAO.EventFailedRepository;
import com.smith.manager.config.ManagerMapper;
import com.smith.manager.controller.ManagerController;
import com.smith.manager.entity.EventFailedEntity;
import com.smith.manager.response.FailedEventResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private EventFailedRepository eventFailedRepository;

    public List<FailedEventResponse> getFailedEvent(List<Long> ids) {
        List<EventFailedEntity> eventList = new LinkedList<>();

        logger.info("Extracting started");

        if (CollectionUtils.isEmpty(ids)) {
            logger.info("Extracting all failed events");

            eventList = eventFailedRepository.findAll();
        } else {
            logger.info("Extracting failed events with ids: {}", ids);

            eventList = eventFailedRepository.findAllById(ids);
        }

        List<FailedEventResponse> response = eventList.stream().map(ManagerMapper::toResponse).toList();

        return response;
    }
}