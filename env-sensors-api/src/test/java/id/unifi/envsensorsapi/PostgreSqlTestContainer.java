package id.unifi.envsensorsapi;

import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgreSqlTestContainer extends PostgreSQLContainer<PostgreSqlTestContainer> {
    private static final String IMAGE_VERSION = "postgres:11-alpine";
    private static PostgreSqlTestContainer container;

    private PostgreSqlTestContainer() {
        super(IMAGE_VERSION);
    }

    @Bean
    public static PostgreSqlTestContainer getInstance() {
        if (container == null) {
            container = new PostgreSqlTestContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();

        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
