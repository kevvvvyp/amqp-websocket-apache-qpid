package com.cgi.example.amqpwebsocketapacheqpid;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jms.JmsSendingMessageHandler;
import org.springframework.integration.jms.dsl.Jms;
import org.springframework.jms.core.JmsTemplate;

/**
 * Configuration for inbound requests
 */
@Log4j2
@Configuration
public class OutboundConfiguration {

    /**
     * Creates an outbound JMS channel adapter.
     *
     * @return Outbound Channel Adapter
     * @see <a href="https://docs.spring.io/spring-integration/reference/html/jms.html">Spring Integration JMS</a>
     */
    @Bean
    public JmsSendingMessageHandler outboundAdapter(final ApplicationProperties applicationProperties,
                                                    final JmsTemplate jmsTemplate) {

        return Jms.outboundAdapter(jmsTemplate) // Use our jms template for outbound messages
                .extractPayload(true) // Extract the SI payload and use it as the JMS payload (rather than the SI message).
                .destination(applicationProperties.getQueueName()) // Our response queue
                .get();

    }
}
