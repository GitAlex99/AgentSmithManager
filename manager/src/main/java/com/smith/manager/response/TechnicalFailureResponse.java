package com.smith.manager.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class TechnicalFailureResponse {

    private long id;
    private String topic;
    private int kafka_partition;
    private long kafka_offset;
    private String stacktrace_listener;
    private JsonNode raw_event;

}
