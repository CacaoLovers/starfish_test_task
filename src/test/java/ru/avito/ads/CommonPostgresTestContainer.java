package ru.avito.ads;

import org.testcontainers.containers.PostgreSQLContainer;

public class CommonPostgresTestContainer extends PostgreSQLContainer<CommonPostgresTestContainer> {

    private static CommonPostgresTestContainer container;

    private CommonPostgresTestContainer(){
        super("postgres:latest");
    }

    public static CommonPostgresTestContainer getInstance() {
        if (container == null) {
            container = new CommonPostgresTestContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();

    }

    @Override
    public void stop() {

    }

}
