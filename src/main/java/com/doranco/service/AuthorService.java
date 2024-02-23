package com.doranco.service;



import com.doranco.entity.Author;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class AuthorService {

	   private final EntityManager manager;

	    public AuthorService(EntityManager manager)
	    {
	        this.manager = manager;
	    }

	    public void create(Author author)
	    {
	        EntityTransaction transaction = manager.getTransaction();
	        transaction.begin();
	        manager.persist(author);
	        transaction.commit();
	    }

	    
	}

