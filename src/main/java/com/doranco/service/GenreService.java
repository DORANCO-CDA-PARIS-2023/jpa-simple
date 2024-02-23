package com.doranco.service;

import com.doranco.entity.Genre;
import com.doranco.entity.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class GenreService {

    private final EntityManager manager;

    public GenreService(EntityManager manager)
    {
        this.manager = manager;
    }

    public void create(Genre genre)
    {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(genre);
        transaction.commit();
    }

 
}
