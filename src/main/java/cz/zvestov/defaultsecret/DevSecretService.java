package cz.zvestov.defaultsecret;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

/**
 * Specialization of {@link SecretService} for development purpose only.
 * Generates random value on each start of the application.
 *
 * @author Lubos Racansky
 */
class DevSecretService implements SecretService {

    private static final Logger logger = LoggerFactory.getLogger(DevSecretService.class);

    private final byte[] secret = new byte[64];

    public DevSecretService() {
        logger.warn("Running in DEV mode: Randomly generated secret is used");
        new SecureRandom().nextBytes(secret);
    }

    @Override
    public byte[] fetchSecret() {
        return secret;
    }
}
