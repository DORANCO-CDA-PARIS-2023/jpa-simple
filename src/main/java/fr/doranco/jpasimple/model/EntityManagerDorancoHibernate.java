package fr.doranco.jpasimple.model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EntityManagerDorancoHibernate {

    private static EntityManagerDorancoHibernate INSTANCE;

    private EntityManagerFactory emf;

    private EntityManagerDorancoHibernate() {
        this.emf = Persistence.createEntityManagerFactory("dorancoHibernate");
    }

    public static EntityManagerDorancoHibernate getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new EntityManagerDorancoHibernate();
        }
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.emf;
    }
}
