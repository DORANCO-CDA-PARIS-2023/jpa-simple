package com.doranco.DAO;

import java.sql.SQLException;
import java.util.List;

import com.doranco.entity.Livre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LivreDAO implements IlivreDAO {

	@Override
	public Livre find(int id, Livre livre) throws SQLException {
EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Livre livreretourne = em.find(Livre.class, id);
		
		transaction.commit();
		
		em.close();
		
		
		return livreretourne;
		
	}

	@Override
	public List<Livre> findAll() throws SQLException {
		EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
	    
	    
	    String jpql = "SELECT l FROM Livre l";
	    TypedQuery<Livre> query = em.createQuery(jpql, Livre.class);
	    
	   
	    List<Livre> livres = query.getResultList();
	    
	    em.close();
	    
	    return livres;
	}

	@Override
	public void create(Livre livre) throws SQLException {
		
		EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(livre);
		
		
		transaction.commit();
		
		em.close();
		
	}

	@Override
	public void delete(int id) throws SQLException {
		EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		 
	    Livre livre = em.find(Livre.class, id);
	    
	    if (livre != null) {
	        em.remove(livre);
	    }
		transaction.commit();
		
		em.close();
		
	}

	@Override
	public Livre change(int id, Livre livreMaj) throws SQLException {
		EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		Livre livre = em.find(Livre.class, id);
		

	    if (livreMaj.getTitre() != null) {
	        livre.setTitre(livreMaj.getTitre());
	    }
	    if (livreMaj.getAuteur() != null) {
	        livre.setAuteur(livreMaj.getAuteur());
	    }
	    if (livreMaj.getGenre() != null) {
	        livre.setGenre(livreMaj.getGenre());
	    }
	    if (livreMaj.getAnnee_publication() != 0) {
	        livre.setAnnee_publication(livreMaj.getAnnee_publication());
	    }
	    if (livreMaj.getNombre_page() != 0) {
	        livre.setNombre_page(livreMaj.getNombre_page());
	    }
		
		em.merge(livre);
		
		transaction.commit();
		
		em.close();
		
		return livre;
	}
		public List<Livre> findByAuteur(String auteur) {
	    EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
	    
	  
	    String jpql = "SELECT l FROM Livre l WHERE l.auteur LIKE :auteur";
	    TypedQuery<Livre> query = em.createQuery(jpql, Livre.class);
	    query.setParameter("auteur", "%" + auteur + "%");
	    
	
	    List<Livre> livres = query.getResultList();
	    
	    em.close();
	    
	    return livres;
	}
		
		public List<Livre> findByTitre(String titre) {
		    EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
		    
		   
		    String jpql = "SELECT l FROM Livre l WHERE l.titre LIKE :titre";
		    TypedQuery<Livre> query = em.createQuery(jpql, Livre.class);
		    query.setParameter("titre", "%" + titre + "%");
		    
		    List<Livre> livres = query.getResultList();
		    
		    em.close();
		    
		    return livres;
		}


	

}
