package com.cgi.example.amqpwebsocketapacheqpid;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * Configurable application properties
 */
@Data
@Log4j2
@Validated
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private static final String MISSING_MSG = "Missing property";
    private static final String OUT_OF_BOUNDS = "Property was out of bounds";
    private static final String NOT_BLANK = "Property cannot be blank";
    @NotBlank(message = NOT_BLANK)
    private String queueName;

    public ApplicationProperties() {

    }
}



