package com.cgi.example.amqpwebsocketapacheqpid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.integration.jms.dsl.Jms;
import org.springframework.jms.core.JmsTemplate;

/**
 * Configuration for inbound requests
 */
@Configuration
public class InboundConfiguration {

    /**
     * Creates an Inbound JMS Message Driven channel adapter
     *
     * @return Message Driven channel adapter
     * @see <a href="https://docs.spring.io/spring-integration/reference/html/jms.html">Spring Integration JMS</a>
     */
    @Bean
    public JmsMessageDrivenEndpoint inboundAdapter(final ApplicationProperties applicationProperties,
                                                   final JmsTemplate jmsTemplate) {

        return Jms.messageDrivenChannelAdapter(jmsTemplate.getConnectionFactory())
                .destination(applicationProperties.getQueueName()) // The queue to monitor
                .extractPayload(true) // Should the payload going into SI be the JMS payload (true) or the JSM message itself?
                .get();
    }
}
