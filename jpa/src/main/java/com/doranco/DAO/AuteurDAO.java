package com.doranco.DAO;

import java.sql.SQLException;
import java.util.List;

import com.doranco.entity.Auteur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AuteurDAO implements IAuteurDAO<Auteur>{

	@Override
	public Auteur find(int id, Auteur auteur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auteur> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Auteur auteur) throws SQLException {
EntityManager em = JavaUtils.getEntityManagerFactory().createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(auteur);
		
		
		transaction.commit();
		
		em.close();
		
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auteur change(int id, Auteur auteur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
