package Doranco.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public final class EntityManagerProvider {

    private static EntityManagerProvider instance;

    private final EntityManagerFactory emf;

    private EntityManagerProvider() throws PersistenceException {
        this.emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static EntityManagerProvider getInstance() throws PersistenceException {
        if (instance == null) {
            instance = new EntityManagerProvider();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.emf;
    }

    public void closeEntityManagerFactory() {
        this.emf.close();
        instance = null;
    }
}
