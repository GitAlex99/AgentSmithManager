package com.smith.manager.config;

import com.smith.manager.entity.EventFailedEntity;
import com.smith.manager.response.FailedEventResponse;

public class ManagerMapper {

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
}
