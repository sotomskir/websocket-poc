package pl.sotomski.wspoc.ws.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    private ApplicationProperties applicationProperties;

    public WebSocketConfig(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        if (!applicationProperties.getMessageBroker().getEnabled()) {
            config.enableSimpleBroker("/topic");
        } else {
            config.enableStompBrokerRelay("/topic")
                .setRelayHost(applicationProperties.getMessageBroker().getHost())
                .setRelayPort(applicationProperties.getMessageBroker().getPort())
            .setSystemHeartbeatReceiveInterval(1000)
            .setSystemHeartbeatSendInterval(1000);
        }
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/").setAllowedOrigins("*").withSockJS();
    }

    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.setMessageSizeLimit(500 * 1024);
        registration.setSendBufferSizeLimit(1024 * 1024);
        registration.setSendTimeLimit(1000);
    }

}
