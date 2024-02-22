package doranco;

import doranco.Entity.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class AppLivre {

    public static void ajouterLivre(String titre, String auteur, String genre, int anneePublication, int nombrePages) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CoursJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); // help :
                                                    // https://stackoverflow.com/questions/8464370/jpa-when-to-use-gettransaction-when-persisting-objects

            // We create an instance
            Livre nouveauLivre = new Livre();
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
            List<Livre> livres = entityManager.createQuery("SELECT l FROM Livre l", Livre.class).getResultList();
            for (Livre livre : livres) {
                System.out.println(livre);
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void main(String[] args) {
        // After i must add the scanner for this, this is just to debug
        // ajouterLivre("Test titre", "Test auteur", "Fiction", 2024, 2);
        afficherLivres();

    }
}
