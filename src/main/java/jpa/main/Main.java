package jpa.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa.entity.Livre;

public class Main {

	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaSimple");
		 try (EntityManager em = emf.createEntityManager()) {
		 EntityTransaction transaction = em.getTransaction();
//		 transaction.begin();
		 // Opérations CRUD avec la classe Employee
//		 Livre newLivre = new Livre();
//		 newLivre.setTitre("L'art de la guerre");
//		 newLivre.setAuteur("Sun Tzu");
//		 newLivre.setGenre("Essai");
//		 newLivre.setAnneePublication(-350);
//		 newLivre.setNombreDePages(300);
//		 em.persist(newLivre); // Create
//		 Livre foundLivre = em.find(Livre.class, 1L); // Read
//		 foundLivre.setGenre("SF");
//		 em.merge(foundLivre); // Update
//		 em.remove(em.find(Livre.class, 1L)); // Delete
//		 transaction.commit();
		 
		 transaction.begin();
		 transaction.commit();
		 
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
		 emf.close();
		 }

	}

}
