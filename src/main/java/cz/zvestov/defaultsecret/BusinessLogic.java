package cz.zvestov.defaultsecret;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Demonstrates dependency on {@link SecretService}.
 *
 * @author Lubos Racansky
 */
@Component
class BusinessLogic {

    private static final Logger logger = LoggerFactory.getLogger(BusinessLogic.class);

    @Autowired
    BusinessLogic(SecretService secretService) {
        // TODO do NOT ever log secrets in the production, for demo purpose only
        final byte[] secret = Base64.getEncoder().encode(secretService.fetchSecret());
        if (logger.isDebugEnabled()) {
            logger.debug("Secret: {}", new String(secret, StandardCharsets.UTF_8));
        }
    }

}
