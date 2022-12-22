package id.unifi.envsensorsapi.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class LoggerUtilTest {

    @Test
    void testLoggerWillWorkAsExpected() {
        LoggerUtil.info("test");

        assertThat(LoggerUtil.getLogger()).isNotNull();
    }

}
