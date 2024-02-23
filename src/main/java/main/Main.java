package main;
	
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpa.dao.ILivreDAO;
import jpa.dao.LivreDAOImpl;
import entity.Livre;

public class Main {
	
	public static void main(String[] args) {

		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaSimple");
		 try (EntityManager em = emf.createEntityManager()) {
		 EntityTransaction transaction = em.getTransaction();
		 transaction.begin();
		 Livre newLivre = new Livre();
		 newLivre.setTitre("Dracula");
		 newLivre.setAuteur("Bram Stoker");
		 newLivre.setGenre("Fantastique");
		 newLivre.setAnneePublication(1839);
		 newLivre.setNombreDePages(600);
		 em.persist(newLivre); // Create
		 Livre foundLivre = em.find(Livre.class, 1L); // Read
		 foundLivre.setGenre("SF");
		 em.merge(foundLivre); // Update
		 em.remove(em.find(Livre.class, 1L)); // Delete
		 transaction.commit();
		 
	     ILivreDAO livreDAO = new LivreDAOImpl();
		 System.out.println(livreDAO.getById(em, 1).toString());
		 System.out.println(livreDAO.totalPages(em, "Dick"));
		 transaction.begin();
		 livreDAO.modifierNombrePages(em, 16, 4000);
		 transaction.commit();
		 
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
		 emf.close();
		 }
	}
}
