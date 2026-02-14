package com.smith.manager.client;

import com.smith.manager.dto.SendEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IngestionClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ingestion.rest.send.url}")
    private String ingestionUrl;

    public void sendEvent(SendEventDTO dto){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SendEventDTO> entity = new HttpEntity<>(dto, headers);

        restTemplate.exchange(
                ingestionUrl,
                HttpMethod.POST,
                entity,
                Void.class
        );

    }
}
