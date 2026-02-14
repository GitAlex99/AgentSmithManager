package com.smith.manager.dto;


import com.fasterxml.jackson.databind.JsonNode;
import com.smith.manager.model.EventType;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class SendEventDTO implements Serializable {
    private EventType type;
    private String source;
    private JsonNode payload;
    private Timestamp timestamp;
    private UUID clientId;

}