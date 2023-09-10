package cz.zvestov.defaultsecret;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;

/**
 * Test of configuration to initialize {@link DevSecretService}.
 *
 * @author Lubos Racansky
 */
@SpringBootTest
@ActiveProfiles("dev")
class DevSecretServiceTest {

    @Autowired
    private SecretService tested;

    @Test
    void contextLoads() {
        assertThat(tested, isA(DevSecretService.class));
    }

}
