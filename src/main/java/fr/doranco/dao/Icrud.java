package fr.doranco.dao;
import java.util.List;

import jakarta.persistence.EntityManager;

public interface Icrud<T> {
    public List<T> findAll(EntityManager em) throws Exception;

    public T getById(EntityManager em, int id) throws Exception;

    public void add(EntityManager em, T entity) throws Exception;

    public void remove(EntityManager em, T entity) throws Exception;

    public void update(EntityManager em, T entity) throws Exception;

    public T findById(EntityManager em, int id) throws Exception;

    public List<T> findByTitle(EntityManager em, String title) throws Exception;
}
