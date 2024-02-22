package fr.doranco.jpasimple.service;

import fr.doranco.jpasimple.entity.Book;
import fr.doranco.jpasimple.model.EntityManagerDorancoHibernate;
import fr.doranco.jpasimple.utils.ScannerUtils;
import jakarta.persistence.*;

import java.io.InputStream;
import java.util.Scanner;

public final class JpaCLI {

    private EntityManagerFactory emf;
    private final Scanner sc;

    private final String mediumSeparator = "----------------------------------------------------------------------------------------";


    public JpaCLI(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
    }

    public int start() {
        try {
            this.emf = EntityManagerDorancoHibernate.getINSTANCE().getEntityManagerFactory();
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
            return 1;
        }

        int actionId;
        while ((actionId = getActions()) != 10) {
            switch (actionId) {
                case 1 -> addBookAction();
                case 2 -> displayAllBookAction();
                case 3 -> findBookByTitleAction();
                case 4 -> findBookByAuthorAction();
                case 5 -> findBookByTypeAction();
                case 6 -> findBookByYearPublishAction();
                case 7 -> displayTotalPageNumberByAuthorAction();
                case 8 -> updatePageNumberAction();
                case 9 -> deleteBookAction();
            }
        }

        EntityManagerDorancoHibernate.getINSTANCE().closeEntityManagerFactory();
        return 0;
    }

    private void addBookAction() {
        Book book = new Book();
        book.setTitle(ScannerUtils.getString(
                sc,
                "Entrez un titre → ",
                false
        ));
        book.setAuthor(ScannerUtils.getString(
                sc,
                "Entrez le nom complet de l'auteur → ",
                false
        ));
        book.setType(ScannerUtils.getString(
                sc,
                "Entrez le genre de livre → ",
                false
        ));
        book.setPageNumber(ScannerUtils.getInt(
                sc,
                "Entrez le nombre de page du livre → ",
                1,
                Integer.MAX_VALUE
        ));
        book.setYearPublish(ScannerUtils.getInt(
                sc,
                "Entrez l'année de publication du livre → ",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        ));

        System.out.println(mediumSeparator);


        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(book);
            transaction.commit();
            System.out.println("Livre enregistré avec succès.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayAllBookAction() {
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findAll = em.createNamedQuery("findAll", Book.class);
            findAll.getResultStream().map(Book::toString).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByTitleAction() {
        String title = ScannerUtils.getString(
                sc,
                "Entrez le titre du livre recherché → ",
                false
        );
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findByTitle = em.createNamedQuery("findByTitle", Book.class);
            findByTitle.setParameter("title", title);
            findByTitle.getResultStream().map(Book::toString).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByAuthorAction() {
        String author = ScannerUtils.getString(
                sc,
                "Entrez le nom (complet) de l'auteur du livre recherché → ",
                false
        );
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findByAuthor = em.createNamedQuery("findByAuthor", Book.class);
            findByAuthor.setParameter("author", author);
            findByAuthor.getResultStream().map(Book::toString).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByTypeAction() {
        String type = ScannerUtils.getString(
                sc,
                "Entrez le genre du livre recherché → ",
                false
        );
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findByType = em.createNamedQuery("findByType", Book.class);
            findByType.setParameter("type", type);
            findByType.getResultStream().map(Book::toString).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByYearPublishAction() {
        int yearPublish = ScannerUtils.getInt(
                sc,
                "Entrez l'année de publication du livre recherché → ",
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        );
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findByYearPublish = em.createNamedQuery("findByYearPublish", Book.class);
            findByYearPublish.setParameter("yearPublish", yearPublish);
            findByYearPublish.getResultStream().map(Book::toString).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void displayTotalPageNumberByAuthorAction() {
        String author = ScannerUtils.getString(
                sc,
                "Entrez le nom (complet) de l'auteur pour lequel vous souhaitez afficher le nombre total de pages → ",
                false
        );
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findByAuthor = em.createNamedQuery("findByAuthor", Book.class);
            findByAuthor.setParameter("author", author);
            int pagesSum = findByAuthor.getResultStream().mapToInt(Book::getPageNumber).sum();
            System.out.println("Nombre de pages de l'auteur: " + pagesSum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updatePageNumberAction() {
        long bookId = ScannerUtils.getLong(
                sc,
                "Entrez l'id du livre pour lequel vous souhaitez modifier le nombre de page → ",
                1L,
                Long.MAX_VALUE
        );
        int pageNumber = ScannerUtils.getInt(
                sc,
                "Entrez le nombre de page que vous souhaitez affecter au livre → ",
                1,
                Integer.MAX_VALUE
        );

        System.out.println(mediumSeparator);

        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Book book = em.find(Book.class, bookId);

            if (book == null) {
                System.out.println("Il n'y a aucun book avec l'id " + bookId + ".");
                return;
            }

            int oldPageNumber = book.getPageNumber();
            book.setPageNumber(pageNumber);
            em.merge(book);

            transaction.commit();

            System.out.println(String.format(
                    "Nombre de page modifié avec succès (%d → %d).",
                    oldPageNumber,
                    pageNumber
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteBookAction() {
        long bookId = ScannerUtils.getLong(
                sc,
                "Entrez l'id du livre que vous souhaitez supprimer → ",
                1L,
                Long.MAX_VALUE
        );

        System.out.println(mediumSeparator);

        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Book book = em.find(Book.class, bookId);

            if (book == null) {
                System.out.println("Il n'y a aucun book avec l'id " + bookId + ".");
                return;
            }
            em.remove(book);

            transaction.commit();

            System.out.println("Le livre avec l'id " + bookId + " a bien été supprimé.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int getActions() {
        int result = 0;

        do {
            String prompt = """
                    ========================================================================================
                    1. Ajouter un livre
                    2. Afficher tous les livres
                    3. Rechercher un livre par titre
                    4. Rechercher un livre par auteur
                    5. Rechercher un livre par genre
                    6. Rechercher un livre par année de publication
                    7. Afficher le nombre total de pages de tous les livres par auteur
                    8. Modifier le nombre de pages d'un livre
                    9. Supprimer un livre
                    10. Quitter le programme
                    ========================================================================================
                    Entrez votre choix → """;
            System.out.print(prompt);
            try {
                int input = sc.nextInt();
                if (input > 0 && input < 11) {
                    result = input;
                }
            } catch (Exception ignored) {

            } finally {
                sc.nextLine();
            }
        } while (result == 0);

        return result;
    }

}
