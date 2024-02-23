package action;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import dao.ILivreDao;
import dao.LivreDao;
import entity.Livre;

public class LivreAction {
	
	public void start() throws Exception {
    	ILivreDao livreDAO = new LivreDao();
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
	    	System.out.println("10 - Modifier le nombre de pages d'un livre");
	
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
	        		livreToAdd.setNombrePages(nombreDePages);
	       		 	transaction.begin();
	    			livreDAO.add(em, livreToAdd);
	    			transaction.commit();
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		break;
	    	case 5:
	        	try {
	        		int idSuppr = searchscan.nextInt();
	    			livreDAO.remove(em, idSuppr);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		break;
	    	case 6:
	        	try {
	        		String rechercheByTitre = searchscan.nextLine();
	    			livreDAO.findByTitre(em, rechercheByTitre);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		break;
	    	case 7:
	        	try {
	        		String rechercheByAuteur = searchscan.nextLine();
	    			livreDAO.findByAuteur(em, rechercheByAuteur);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		break;
	    	case 8:
	        	try {
	        		String rechercheByGenre = searchscan.nextLine();
	    			livreDAO.findByGenre(em, rechercheByGenre);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		break; 
	    	case 9:
	        	try {
	        		int rechercheByAnnee = searchscan.nextInt();
	    			livreDAO.findByAnneePublication(em, rechercheByAnnee);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		break;
	    	case 10:
	        	try {
	        		int idModif = searchscan.nextInt();
	        		int nouveauNombre = searchscan.nextInt();
	    			livreDAO.modifierNombrePages(em, idModif, nouveauNombre);;
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
