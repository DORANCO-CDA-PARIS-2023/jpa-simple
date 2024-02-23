package com.doranco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doranco.DAO.AuteurDAO;
import com.doranco.DAO.LivreDAO;
import com.doranco.entity.Auteur;
import com.doranco.entity.Livre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	
    	Auteur auteur = new Auteur("Margaret", "Mitchell");
    	Auteur auteur1 = new Auteur("Tom", "Sawyer");
    	Auteur auteur2 = new Auteur("Louis", "Roqual");
    	
    	AuteurDAO auteurDAO = new AuteurDAO();
    	AuteurDAO auteurDAO1 = new AuteurDAO();
    	AuteurDAO auteurDAO2 = new AuteurDAO();
    	
    	auteurDAO.create(auteur);
    	auteurDAO1.create(auteur1);
    	auteurDAO2.create(auteur2);
    	
        Livre Livre1 = new Livre();
        Livre1.setTitre("Autant en emporte le vent");
        Livre1.setAuteur(auteur);
        Livre1.setGenre("Drame");
        Livre1.setAnnee_publication(1937);
        Livre1.setNombre_page(712);
        
        LivreDAO livreDAO = new LivreDAO();
        
        livreDAO.create(Livre1);
        
        Livre Livre2 = new Livre();
        Livre1.setTitre("Demain est loin");
        Livre1.setAuteur(auteur2);
        Livre1.setGenre("Drame");
        Livre1.setAnnee_publication(1980);
        Livre1.setNombre_page(940);
        
        LivreDAO livreDAO1 = new LivreDAO();
        
        livreDAO1.create(Livre2);
        
        Livre Livre3 = new Livre();
        Livre1.setTitre("La classe à Dallas");
        Livre1.setAuteur(auteur1);
        Livre1.setGenre("Horreur");
        Livre1.setAnnee_publication(2021);
        Livre1.setNombre_page(1210);
        
        LivreDAO livreDAO2 = new LivreDAO();
        
        livreDAO2.create(Livre3);
        
        List<Livre> livres = new ArrayList<Livre>();
    	
    	LivreDAO livreDao = new LivreDAO();
    	
    	livres = livreDao.findAll();
    	
    	for (Livre livre : livres) {
    	    System.out.println(livre);
    	}
        
        /*
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
    	
    	LivreDAO livreDAO = new LivreDAO();
    	List<Livre> livres = livreDAO.findByTitre("vent");

    	for (Livre livre : livres) {
    	    System.out.println(livre.getTitre());
    	}
*/
    	
    	
    	
    }
}
