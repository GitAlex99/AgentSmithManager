package com.smith.manager.service;

import com.smith.manager.DAO.EventFailedRepository;
import com.smith.manager.DAO.EventRepository;
import com.smith.manager.DAO.TechnicalFailureRepository;
import com.smith.manager.config.ManagerMapper;
import com.smith.manager.entity.EventEntity;
import com.smith.manager.entity.EventFailedEntity;
import com.smith.manager.entity.TechnicalFailureEntity;
import com.smith.manager.response.EventResponse;
import com.smith.manager.response.FailedEventResponse;
import com.smith.manager.response.TechnicalFailureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import static com.smith.manager.specification.EventSpecification.*;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private EventFailedRepository eventFailedRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TechnicalFailureRepository technicalRepository;

    public List<FailedEventResponse> getFailedEvent(List<Long> ids) {
        List<EventFailedEntity> eventList = new LinkedList<>();

        logger.info("Extraction started");

        if (CollectionUtils.isEmpty(ids)) {
            logger.info("Extracting all failed events");

            eventList = eventFailedRepository.findAll();
        } else {
            logger.info("Extracting failed events with ids: {}", ids);

            eventList = eventFailedRepository.findAllById(ids);
        }

        return eventList.stream().map(ManagerMapper::toResponse).toList();
    }

    public List<EventResponse> getEvent(List<Long> ids, List<String> topics, long offsetFrom, long offsetTo, Timestamp sentAtFrom, Timestamp sentAtTo) {
        List<EventEntity> eventList = new LinkedList<>();
        Specification<EventEntity> specEvent = Specification
                .allOf(
                        ids(ids),
                        topics(topics),
                        offset(offsetFrom,offsetTo),
                        sentAt(sentAtFrom, sentAtTo)
                        );

        logger.info("Extraction started");

        logger.info("Extracting all events");

        eventList = eventRepository.findAll(specEvent);

        return eventList.stream().map(ManagerMapper::toResponse).toList();
    }

    public List<TechnicalFailureResponse> getTechnicalFailure() {
        logger.info("Extraction started");

        logger.info("Extracting all failed events");

        List<TechnicalFailureEntity> failureList = technicalRepository.findAll();

        return failureList.stream().map(ManagerMapper::toResponse).toList();
    }
}