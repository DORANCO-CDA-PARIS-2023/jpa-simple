package com.doranco.DAO;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JavaUtils {
	
	private static final String PERSISTENCE_UNIT_NAME = "jpa";
	private static EntityManagerFactory factory;

    private JavaUtils() {
    }

    public static  EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}