package cz.zvestov.defaultsecret;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/**
 * Specialization of {@link SecretService} loading secret from a file.
 *
 * @author Lubos Racansky
 */
class FileSecretService implements SecretService {

    private static final Logger logger = LoggerFactory.getLogger(FileSecretService.class);

    private final byte[] secret;

    public FileSecretService(Path path) throws IOException {
        logger.info("Opening file with secret, path: {}", path);
        secret = Base64.getDecoder().decode(Files.readAllLines(path).get(0));
    }

    @Override
    public byte[] fetchSecret() {
        return secret;
    }
}
