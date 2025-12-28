package com.smith.manager.response;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class FailedEventResponse implements Serializable {

    private String topic;
    private int partition;
    private long offset;
    private UUID id_event;
    private String payload;
    private String exception_type;
    private String exception_message;
    private String stacktrace;
    private String consumer_group;
    private Integer retry_count;
    private Timestamp created_at;
    private Timestamp sent_at;
    private String status;
    private Timestamp failed_at;
}
