package fr.doranco.jpasimple.service;

import fr.doranco.jpasimple.entity.Book;
import fr.doranco.jpasimple.model.EntityManagerDorancoHibernate;
import fr.doranco.jpasimple.utils.ScannerUtils;
import jakarta.persistence.*;

import java.io.InputStream;
import java.util.Scanner;

public final class JpaCLI {

    private InputStream inputStream;
    private EntityManagerFactory emf;

    private String mediumSeparator = "----------------------------------------------------------------------------------------";


    public JpaCLI(InputStream inputStream) {
        this.inputStream = inputStream;
        this.emf = EntityManagerDorancoHibernate.getINSTANCE().getEntityManagerFactory();
    }

    public int start() {
        Scanner sc = new Scanner(inputStream);

        int actionId;
        while ((actionId = getActions(sc)) != 10) {
            switch (actionId) {
                case 1 -> addBookAction(sc);
                case 2 -> displayAllBookAction(sc);
                case 3 -> findBookByTitleAction(sc);
                case 4 -> findBookByAuthorAction(sc);
                case 5 -> findBookByTypeAction(sc);
                case 6 -> findBookByYearPublishAction(sc);
                case 7 -> displayTotalPageNumberByAuthorAction(sc);
                case 8 -> updatePageNumberAction(sc);
                case 9 -> deleteBookAction(sc);
            }
        }
        return 0;
    }

    private void addBookAction(Scanner sc) {
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

    private void displayAllBookAction(Scanner sc) {
        System.out.println(mediumSeparator);
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Book> findAll = em.createNamedQuery("findAll", Book.class);
            findAll.getResultStream().map(Book::toString).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByTitleAction(Scanner sc) {
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

    private void findBookByAuthorAction(Scanner sc) {
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

    private void findBookByTypeAction(Scanner sc) {
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

    private void findBookByYearPublishAction(Scanner sc) {
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

    private void displayTotalPageNumberByAuthorAction(Scanner sc) {
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

    private void updatePageNumberAction(Scanner sc) {
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

    private void deleteBookAction(Scanner sc) {
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

    private int getActions(Scanner sc) {
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
