package id.unifi.envsensorsapi.utils;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    @Getter
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(String message, Object object) {
        logger.info(message, object);
    }

    public static void error(String message, Object object) {
        logger.error(message, object);
    }

}
