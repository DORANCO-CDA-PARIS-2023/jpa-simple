package com.doranco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doranco.DAO.LivreDAO;
import com.doranco.entity.Livre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	/*
        Livre Livre1 = new Livre();
        Livre1.setTitre("Autant en emporte le vent");
        Livre1.setAuteur("Margaret Mitchell");
        Livre1.setGenre("Drame");
        Livre1.setAnnee_publication(1937);
        Livre1.setNombre_page(712);
        
        LivreDAO livreDAO = new LivreDAO();
        
        livreDAO.create(Livre1);
        
        
    	Livre livreMaj = new Livre();
    	livreMaj.setGenre("Drame");
    	LivreDAO livreDAO1 = new LivreDAO();
    	
    	livreDAO1.change(6, livreMaj);
    	
    	Livre livre = new Livre();
    	
    	LivreDAO livreDao = new LivreDAO();
    	
    System.out.println(livreDao.find(7, livre));	
    
    List<Livre> livres = new ArrayList<Livre>();
    	
    	LivreDAO livreDao = new LivreDAO();
    	
    	livres = livreDao.findAll();
    	
    	for (Livre livre : livres) {
    	    System.out.println(livre.getTitre());
    	}
    	LivreDAO livreDAO = new LivreDAO();
    	
    	livreDAO.delete(6);
    	LivreDAO livreDAO = new LivreDAO();
    	List<Livre> livres = livreDAO.findByAuteur("Mitchell");

    	for (Livre livre : livres) {
    	    System.out.println(livre.getTitre());
    	}
    	*/
    	LivreDAO livreDAO = new LivreDAO();
    	List<Livre> livres = livreDAO.findByTitre("vent");

    	for (Livre livre : livres) {
    	    System.out.println(livre.getTitre());
    	}

    	
    	
    	
    }
}
