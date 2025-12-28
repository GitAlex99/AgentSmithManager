package com.smith.manager.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.smith.manager.model.EventType;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class EventDTO {
    private UUID id;
    private EventType type;
    private String source;
    private String severity;
    private JsonNode payload;
    private Timestamp timestamp;
    private UUID clientId;
    private Timestamp receivedAt;
    private String version;
}
