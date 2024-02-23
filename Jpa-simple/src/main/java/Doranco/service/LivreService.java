package com.doranco.service;

import com.doranco.entity.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class LivreService {

    private final EntityManager manager;

    public LivreService(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Livre livre) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(livre);
        transaction.commit();
    }

    public List<Livre> findAll() {
        return manager
                .createQuery("SELECT l FROM Livre l", Livre.class)
                .getResultList();
    }

    public List<Livre> findByAuthor(String author) {
        Query query = manager.createQuery("SELECT l FROM Livre l WHERE l.author = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }
}