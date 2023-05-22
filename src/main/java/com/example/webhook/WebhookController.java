package com.example.webhook;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/webhook")
@Api(value = "Webhook Controller", description = "Operations with Webhooks")
public class WebhookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping
    @ApiOperation(value = "Handle incoming webhook", response = String.class)
    public ResponseEntity<String> handleWebhook(@ApiParam(value = "Webhook payload", required = true) @RequestBody String payload) {
        LOGGER.info(payload);
        return ResponseEntity.ok().body("Webhook received successfully");
    }
}
