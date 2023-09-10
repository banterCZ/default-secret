package cz.zvestov.defaultsecret;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Configuration to choose concrete implementation of {@link SecretService}.
 *
 * @author Lubos Racansky
 */
@Configuration
public class SecretConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "cz.zvestov.secret", name = "type", havingValue = "file")
    @ConditionalOnMissingBean(type = "cz.zvestov.defaultsecret.SecretService")
    SecretService fileSecretService(@Value("${cz.zvestov.secret.file.path}")Path path) throws IOException {
        return new FileSecretService(path);
    }

    @Bean
    @Profile("dev")
    @ConditionalOnMissingBean(type = "cz.zvestov.defaultsecret.SecretService")
    SecretService devSecretService() {
        return new DevSecretService();
    }
}
