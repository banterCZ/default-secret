package cz.zvestov.defaultsecret;

/**
 * Secret service.
 *
 * @author Lubos Racansky
 */
public interface SecretService {

    /**
     * Fetch secret.
     *
     * @return secret as byte array
     */
    byte[] fetchSecret();

}
