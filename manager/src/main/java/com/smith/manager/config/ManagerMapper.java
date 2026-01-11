package com.smith.manager.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smith.manager.entity.EventEntity;
import com.smith.manager.entity.EventFailedEntity;
import com.smith.manager.entity.TechnicalFailureEntity;
import com.smith.manager.model.EventType;
import com.smith.manager.response.EventResponse;
import com.smith.manager.response.FailedEventResponse;
import com.smith.manager.response.TechnicalFailureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagerMapper {

    private static final Logger logger = LoggerFactory.getLogger(ManagerMapper.class);


    public static FailedEventResponse toResponse(EventFailedEntity entity){

        FailedEventResponse response = new FailedEventResponse();
        response.setTopic(entity.getTopic());
        response.setPartition(entity.getKafka_partition());
        response.setOffset(entity.getKafka_offset());
        response.setId_event(entity.getId_event());
        response.setPayload(entity.getPayload());
        response.setException_type(entity.getException_type());
        response.setException_message(entity.getException_message());
        response.setStacktrace(entity.getStacktrace());
        response.setConsumer_group(entity.getConsumer_group());
        response.setRetry_count(entity.getRetry_count());
        response.setCreated_at(entity.getCreated_at());
        response.setSent_at(entity.getSent_at());
        response.setStatus(entity.getStatus());
        response.setFailed_at(entity.getFailed_at());

        return response;
    }

    public static EventResponse toResponse(EventEntity entity){

        EventResponse response = new EventResponse();
        response.setId(entity.getId_event());
        response.setType(EventType.valueOf(entity.getType()));
        response.setSource(entity.getSource());
        response.setSeverity(entity.getSeverity());
        response.setPayload(entity.getPayload());
        response.setTimestamp(entity.getSent_at());
        response.setClientId(entity.getClientId());
        response.setReceivedAt(entity.getProcessed_at());
        response.setVersion(entity.getVersion());

        return response;
    }

    public static TechnicalFailureResponse toResponse(TechnicalFailureEntity entity){
        JsonNode actualObj = null;
        TechnicalFailureResponse response = new TechnicalFailureResponse();
        response.setId(entity.getId());
        response.setTopic(entity.getTopic());
        response.setKafka_partition(entity.getKafka_partition());
        response.setKafka_offset(entity.getKafka_offset());
        response.setStacktrace_listener(entity.getStacktrace_listener());
        ObjectMapper mapper = new ObjectMapper();
        try {
            actualObj = mapper.readTree(entity.getRaw_event());
            response.setRaw_event(actualObj);
        }catch (Exception ex){
            logger.error("Error during mapping of raw event");
        }
        return response;
    }
}
