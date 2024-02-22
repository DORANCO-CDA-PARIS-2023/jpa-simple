package doranco;

import doranco.Entity.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppLivre {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cours");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Livre newArticle = new Livre();
        newArticle.setTitle("Titre 1");
        entityManager.persist(newArticle);

        transaction.commit();

        Livre article = entityManager.find(Livre.class, 1L);
        System.out.println(article);

        entityManager.close();
        entityManagerFactory.close();
    }
}
