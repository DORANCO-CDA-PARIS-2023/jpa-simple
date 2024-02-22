package Doranco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LivreDAOImpl implements LivreDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioPU");

    @Override
    public void ajouterLivre(Livre livre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(livre);
        em.getTransaction().commit();
        em.close();
    }
}
