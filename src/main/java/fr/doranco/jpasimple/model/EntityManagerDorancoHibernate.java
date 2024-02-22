package fr.doranco.jpasimple.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public final class EntityManagerDorancoHibernate {

    private static EntityManagerDorancoHibernate INSTANCE;

    private EntityManagerFactory emf;

    private EntityManagerDorancoHibernate() throws PersistenceException {
        this.emf = Persistence.createEntityManagerFactory("dorancoHibernat");
    }

    public static EntityManagerDorancoHibernate getINSTANCE() throws PersistenceException {
        if (INSTANCE == null) {
            INSTANCE = new EntityManagerDorancoHibernate();
        }
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.emf;
    }
}
