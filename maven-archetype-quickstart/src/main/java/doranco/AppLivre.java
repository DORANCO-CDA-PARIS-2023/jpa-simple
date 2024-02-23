package doranco;

import doranco.Entity.OldLivre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AppLivre {

    public static void ajouterLivre(String titre, String auteur, String genre, int anneePublication, int nombrePages) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); // help :
                                                    // https://stackoverflow.com/questions/8464370/jpa-when-to-use-gettransaction-when-persisting-objects

            // We create an instance
            OldLivre nouveauLivre = new OldLivre();
            nouveauLivre.setTitre(titre);
            nouveauLivre.setAuteur(auteur);
            nouveauLivre.setGenre(genre);
            nouveauLivre.setAnneePublication(anneePublication);
            nouveauLivre.setNombrePages(nombrePages);

            // To insert the data
            entityManager.persist(nouveauLivre);

            entityManager.getTransaction().commit(); // help :
                                                     // https://stackoverflow.com/questions/26200324/how-to-rollback-transaction-in-jpa

            System.out.println("Livre ajouté avec succès : " + nouveauLivre);
        } catch (RuntimeException e) {
        }
        // I forgot to close it before
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void afficherLivres() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // We use the NamedQuery here
            List<OldLivre> livres = entityManager.createNamedQuery("Livre.findAll", OldLivre.class).getResultList();
            for (OldLivre livre : livres) {
                System.out.println("Affichage de TOUS les livres: " + livre.getTitre() + ", Auteur: "
                        + livre.getAuteur() + ", Genre: "
                        + livre.getGenre() + ", Année de publication: " + livre.getAnneePublication()
                        + ", Nombre de pages: " + livre.getNombrePages());
            }
        } catch (RuntimeException e) {
        }
        entityManager.close();
        entityManagerFactory.close();

    }

    public static List<OldLivre> findByTitre(String titre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<OldLivre> query = entityManager.createNamedQuery("Livre.findByTitre", OldLivre.class);
            query.setParameter("titre", "%" + titre + "%"); // To search with all the possibilities in the name
            List<OldLivre> livres = query.getResultList();

            for (OldLivre livre : livres) {
                System.out.println("Voici le résultat de la recherche par TITRE : " + livre.getTitre() +
                        ", Auteur: " + livre.getAuteur() + ", Genre: " + livre.getGenre() +
                        ", Année de publication: " + livre.getAnneePublication() + ", Nombre de pages: "
                        + livre.getNombrePages());
            }
        } catch (RuntimeException e) {
        }
        entityManager.close();
        entityManagerFactory.close();
        return null; // to avoid error from vscode
    }

    public static List<OldLivre> findByAuteur(String auteur) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<OldLivre> query = entityManager.createNamedQuery("Livre.findByAuteur", OldLivre.class);
            query.setParameter("auteur", auteur);
            List<OldLivre> livres = query.getResultList();

            for (OldLivre livre : livres) {
                System.out.println("Voici le résultat de la recherche par AUTEUR : " + livre.getTitre() +
                        ", Auteur: " + livre.getAuteur() + ", Genre: " + livre.getGenre() +
                        ", Année de publication: " + livre.getAnneePublication() + ", Nombre de pages: "
                        + livre.getNombrePages());
            }
        } catch (RuntimeException e) {
        }
        entityManager.close();
        entityManagerFactory.close();
        return null; // to avoid error from vscode
    }

    public static List<OldLivre> findByGenre(String genre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<OldLivre> query = entityManager.createNamedQuery("Livre.findByGenre", OldLivre.class);
            query.setParameter("genre", genre);
            List<OldLivre> livres = query.getResultList();

            for (OldLivre livre : livres) {
                System.out.println("Voici le résultat de la recherche par GENRE : " + livre.getTitre() +
                        ", Auteur: " + livre.getAuteur() + ", Genre: " + livre.getGenre() +
                        ", Année de publication: " + livre.getAnneePublication() + ", Nombre de pages: "
                        + livre.getNombrePages());
            }
        } catch (RuntimeException e) {
        }
        entityManager.close();
        entityManagerFactory.close();
        return null;
    }

    public static void findByAnneePublication(int anneePublication) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<OldLivre> query = entityManager.createNamedQuery("Livre.findByAnneePublication", OldLivre.class);
            query.setParameter("anneePublication", anneePublication);
            List<OldLivre> livres = query.getResultList();

            for (OldLivre livre : livres) {
                System.out.println("Voici le résultat de la recherche par ANNEE : " + livre.getTitre() +
                        ", Auteur: " + livre.getAuteur() + ", Genre: " + livre.getGenre() +
                        ", Année de publication: " + livre.getAnneePublication() + ", Nombre de pages: "
                        + livre.getNombrePages());
            }
        } catch (RuntimeException e) {
        }
        entityManager.close();
        entityManagerFactory.close();
    }

    public static List<OldLivre> findByNombrePages(int nombrePages) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<OldLivre> query = entityManager.createNamedQuery("Livre.findByNombrePages", OldLivre.class);
            query.setParameter("nombrePages", nombrePages);
            List<OldLivre> livres = query.getResultList();

            for (OldLivre livre : livres) {
                System.out.println("Voici le résultat de la recherche par NOMBRE de PAGES : " + livre.getTitre() +
                        ", Auteur: " + livre.getAuteur() + ", Genre: " + livre.getGenre() +
                        ", Année de publication: " + livre.getAnneePublication() + ", Nombre de pages: "
                        + livre.getNombrePages());
            }
        } catch (RuntimeException e) {
        }
        entityManager.close();
        entityManagerFactory.close();
        return null;
    }

    // I should have done it case by case and not this way but i have done it this
    // way because i just have read it line by line in the subect

    public static void main(String[] args) {
        // After i must add the scanner for this, this is just to debug
        // ajouterLivre("Test titre 2", "Test 2", "SF", 2022, 2);
        afficherLivres();
        findByAnneePublication(2024);
        findByTitre("Test");
        findByAuteur("Test");
        findByNombrePages(2);
        findByGenre("SF");

    }
}
