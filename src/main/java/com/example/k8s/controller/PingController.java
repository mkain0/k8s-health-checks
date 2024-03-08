package com.example.k8s.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);
    private static final String PING_ENDPOINT = "/ping";

    @GetMapping(value = PING_ENDPOINT)
    public ResponseEntity<Void> ping() {
        LOGGER.info("Ping.................Pong");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

