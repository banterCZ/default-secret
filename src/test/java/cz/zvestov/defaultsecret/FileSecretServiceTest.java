package cz.zvestov.defaultsecret;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;

/**
 * Test of configuration to initialize {@link FileSecretService}.
 *
 * @author Lubos Racansky
 */
@SpringBootTest
@TestPropertySource(properties = {
        "cz.zvestov.secret.type=file",
        "cz.zvestov.secret.file.path=classpath:test-secret.txt"

})
class FileSecretServiceTest {

    @Autowired
    private SecretService tested;

    @Test
    void contextLoads() {
        assertThat(tested, isA(FileSecretService.class));
    }

}
