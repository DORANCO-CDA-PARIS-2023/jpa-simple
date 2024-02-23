package jpa.cli;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.dao.ILivreDAO;
import jpa.dao.LivreDAOImpl;
import jpa.entity.Livre;

public class LivreCLI {
	
	public void start() throws Exception {
    	ILivreDAO livreDAO = new LivreDAOImpl();
    	int choice = 0;
    	Scanner searchscan = new Scanner(System.in);
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaSimple");
		 EntityManager em = emf.createEntityManager();
		 EntityTransaction transaction = em.getTransaction();
    	while(choice != 1) {
    	System.out.println("Quelle action souhaitez-vous effectuer ?");
    	System.out.println("1 - Fermer application");
    	System.out.println("2 - Afficher la liste de tous les livres");
    	System.out.println("3 - Rechercher un livre par ID");
    	System.out.println("4 - Ajouter un livre");
    	System.out.println("5 - Supprimer un livre");
    	System.out.println("6 - Rechercher par titre");
    	System.out.println("7 - Rechercher par auteur");
    	System.out.println("8 - Rechercher par genre");
    	System.out.println("9 - Rechercher par année de publication");
    	System.out.println("10 - Afficher le nombre total de pages d'un auteur");
    	System.out.println("11 - Modifier le nombre de pages d'un livre");

    	System.out.print("Votre choix : ");
    	choice = searchscan.nextInt();
    	switch(choice) {
    	case 1:
    		System.out.println("Fermeture du programme ...");
        	searchscan.close();
        	em.close();
        	emf.close();
    		break;
    	case 2:
        	try {
    			livreDAO.findAll(em);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 3:
        	try {
        		System.out.println("ID à rechercher : ");
        		int idGet = searchscan.nextInt();
    			livreDAO.getById(em, idGet);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 4:
        	try {
        		Livre livreToAdd = new Livre();
        		System.out.println("Titre du livre : ");
        		String titre = searchscan.nextLine();
        		livreToAdd.setTitre(titre);
        		System.out.println("Auteur : ");
        		String auteur = searchscan.nextLine();
        		livreToAdd.setAuteur(auteur);
        		System.out.println("Genre : ");
        		String genre = searchscan.nextLine();
        		livreToAdd.setGenre(genre);
        		System.out.println("Année de publication : ");
        		int annee = searchscan.nextInt();
        		livreToAdd.setAnneePublication(annee);
        		System.out.println("Nombre de pages : ");
        		int nombreDePages = searchscan.nextInt();
        		livreToAdd.setNombreDePages(nombreDePages);
       		 transaction.begin();
    			livreDAO.add(em, livreToAdd);
    		transaction.commit();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 5:
        	try {
        		System.out.println("ID à supprimer : ");
        		int idRemove = searchscan.nextInt();
    			livreDAO.remove(em, idRemove);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 6:
        	try {
        		System.out.println("Titre à rechercher : ");
        		String searchByTitle = searchscan.nextLine();
    			livreDAO.findByTitre(em, searchByTitle);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 7:
        	try {
        		System.out.println("Auteur à rechercher : ");
        		String searchByAuteur = searchscan.nextLine();
    			livreDAO.findByAuteur(em, searchByAuteur);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 8:
        	try {
        		System.out.println("Genre à rechercher : ");
        		String searchByGenre = searchscan.nextLine();
    			livreDAO.findByGenre(em, searchByGenre);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break; 
    	case 9:
        	try {
        		System.out.println("Année à rechercher : ");
        		int searchByAnnee = searchscan.nextInt();
    			livreDAO.findByAnneePublication(em, searchByAnnee);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 10:
        	try {

        		System.out.println("Auteur à compiler : ");
        		String totalAuteur = searchscan.nextLine(); 
        		livreDAO.totalPages(em, totalAuteur);
        		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	case 11:
        	try {
        		System.out.println("ID à modifier : ");
        		int idUpdate = searchscan.nextInt();
        		System.out.println("Nouveau nombre de pages : ");
        		int newNumber = searchscan.nextInt();
    			livreDAO.modifierNombrePages(em, idUpdate, newNumber);;
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		break;
    	default:
    		System.out.println("Choix invalide");
    	}
    	System.out.println("Action effectuée.");
    	}
	}
}
