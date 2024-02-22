package fr.doranco;


import fr.doranco.jpasimple.service.JpaCLI;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dorancoHibernate");
        JpaCLI jpaCLI = new JpaCLI(System.in, emf);
        int exitCode = jpaCLI.start();
        emf.close();
        System.exit(exitCode);
    }

//    public static void main( String[] args ) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dorancoHibernate");
//
//        try (EntityManager em = emf.createEntityManager()) {
//            EntityTransaction transaction = em.getTransaction();
//            transaction.begin();
//            // Opérations CRUD avec la classe Employee
//            Book book = new Book();
//            book.setTitle("Le Petit Prince");
//            book.setAuthor("Antoine de Saint-Exupéry");
//            book.setYearPublish(1943);
//            book.setType("Roman");
//            book.setPageNumber(128);
//            em.persist(book); // Create
//            Book resultBook = em.find(Book.class, 1L); // Read
//            System.out.println(resultBook);
//            resultBook.setAuthor("Anselin Ludovic");
//            em.merge(resultBook);
//
//            TypedQuery<Book> findByTitle = em.createNamedQuery("findByTitle", Book.class);
//            findByTitle.setParameter("title", "Le P%");
//            Stream<Book> resultStream = findByTitle.getResultStream();
//            resultStream.map(Book::toString).forEach(System.out::println);
//
//            TypedQuery<Book> findByAuthor = em.createNamedQuery("findByAuthor", Book.class);
//            findByAuthor.setParameter("author", "anselin ludovic");
//            Stream<Book> resultStream1 = findByAuthor.getResultStream();
//            int pageSum = resultStream1.mapToInt(Book::getPageNumber).sum();
//            System.out.println("Nombre total de page de l'auteur: " + pageSum);
//
//
//            em.remove(resultBook);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            emf.close();
//        }
//    }
}
