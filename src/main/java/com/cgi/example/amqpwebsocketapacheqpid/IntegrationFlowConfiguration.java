package com.cgi.example.amqpwebsocketapacheqpid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.integration.jms.JmsSendingMessageHandler;

/**
 * Flow configuration, this is configures the application processing logic.
 */
@Configuration
public class IntegrationFlowConfiguration {

    /**
     * Creates the send flow to Azure
     *
     * @param outboundAdapter Sends data to the queue
     * @return Impedance trace flow
     */
    @Bean
    public IntegrationFlow sendFlow(final JmsSendingMessageHandler outboundAdapter) {

        return IntegrationFlows.from(MessageChannels.direct("inputChannel"))
                .log("START - Sent message")
                .handle(outboundAdapter) //Send to azure
                .get();
    }

    /**
     * Creates the receive flow from Azure
     *
     * @param inboundAdapter Listens to the request queue
     * @return Impedance trace flow
     */
    @Bean
    public IntegrationFlow receiveFlow(final JmsMessageDrivenEndpoint inboundAdapter) {

        return IntegrationFlows.from(inboundAdapter) // Receive from azure
                .log("END - Received message")
                .handle((message) -> {
                })
                .get();
    }
}
