package com.smith.manager.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.smith.manager.model.EventType;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class EventResponse {
    private UUID id;
    private EventType type;
    private String source;
    private String severity;
    private String payload;
    private Timestamp timestamp;
    private UUID clientId;
    private Timestamp receivedAt;
    private String version;
}
