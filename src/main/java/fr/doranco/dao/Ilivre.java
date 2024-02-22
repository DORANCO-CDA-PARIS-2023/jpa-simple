package fr.doranco.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import fr.doranco.entity.Livre;

public interface Ilivre extends Icrud<Livre> {
    public List<Livre> findAll(EntityManager em) throws Exception;

    public Livre getById(EntityManager em, int id) throws Exception;

    public void add(EntityManager em, Livre entity) throws Exception;

    public void remove(EntityManager em, Livre entity) throws Exception;

    public void update(EntityManager em, Livre entity) throws Exception;

    public Livre findById(EntityManager em, int id) throws Exception;

    public List<Livre> findByTitle(EntityManager em, String title) throws Exception;

}
