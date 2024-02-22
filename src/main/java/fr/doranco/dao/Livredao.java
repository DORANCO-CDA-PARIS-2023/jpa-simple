package fr.doranco.dao;
import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import fr.doranco.entity.Livre;


public class Livredao implements Ilivre {
    
        @Override
        public List<Livre> findAll(EntityManager em) throws SQLException {
            TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l", Livre.class);
            return query.getResultList();
        }
    
        @Override
        public Livre getById(EntityManager em, int id) throws SQLException {
            return em.find(Livre.class, id);
        }
    
        @Override
        public void add(EntityManager em, Livre entity) throws SQLException {
            em.persist(entity);
        }
    
        @Override
        public void remove(EntityManager em, Livre entity) throws SQLException {
            em.remove(entity);
        }
    
        @Override
        public void update(EntityManager em, Livre entity) throws SQLException {
            em.merge(entity);
        }
    
        @Override
        public Livre findById(EntityManager em, int id) throws SQLException {
            return em.find(Livre.class, id);
        }
    
        @Override
        public List<Livre> findByTitle(EntityManager em, String title) throws SQLException {
            Query query = em.createQuery("SELECT l FROM Livre l WHERE l.titre = :titre");
            query.setParameter("titre", title);
            return query.getResultList();
        }
}
