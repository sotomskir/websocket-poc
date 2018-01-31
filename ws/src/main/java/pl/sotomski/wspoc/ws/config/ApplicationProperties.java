package pl.sotomski.wspoc.ws.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Ws.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private final MessageBroker messageBroker = new MessageBroker();

    public MessageBroker getMessageBroker() {
        return messageBroker;
    }

    public static class MessageBroker {
        private Boolean enabled;
        private String host;
        private Integer port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
    }
}
