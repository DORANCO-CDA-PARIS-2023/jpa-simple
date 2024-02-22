package factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {
    private static final String PERSISTENCE_UNIT_NAME = "jpa-simple";
    private static EntityManagerFactory entityManagerFactory;

    private EntityManagerFactoryProvider() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
}