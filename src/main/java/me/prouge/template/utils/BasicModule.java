package me.prouge.template.utils;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import jakarta.persistence.EntityManager;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class BasicModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    EntityManager provideEntityManager() {
        return createEntityManagerFactory("app-unit").createEntityManager();
    }
}
