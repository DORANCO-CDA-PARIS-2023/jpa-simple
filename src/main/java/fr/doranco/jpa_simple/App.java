package fr.doranco.jpa_simple;

import jakarta.persistence.*;
import fr.doranco.entity.*;

public class App 
{
    public static void main( String[] args )
    {
    	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("CoursJpa");
		 try (EntityManager em = emf.createEntityManager()) {
		 EntityTransaction transaction = em.getTransaction();
		 transaction.begin();

		 Book newBook = new Book();
		 newBook.setTitle("The Call Of Cthlhu");
		 newBook.setAuthor("H.P.Lovecraft");
		 newBook.setGenre("Horreur");
		 newBook.setYear(1928);
		 newBook.setPageNumber(80);
		 em.persist(newBook); 
		 Book foundBook = em.find(Book.class, 1); // Read
		 foundBook.setGenre("SF");
		 em.merge(foundBook); // Update
		 // em.remove(em.find(Book.class, 1)); 
		 transaction.commit();
		 
		 //transaction.begin();
		 //transaction.commit();
		 
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
		 emf.close();
		 }
    }
}
