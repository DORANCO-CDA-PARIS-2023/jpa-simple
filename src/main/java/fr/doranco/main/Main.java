package fr.doranco.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import fr.doranco.entity.Livre;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Livre livre = new Livre();
        livre.setTitre("Le seigneur des anneaux");
        livre.setAuteur("J.R.R. Tolkien");
        livre.setGenre("Fantasy");
        livre.setAnneePublication(1954);
        livre.setNombreDePages(423);

        entityManager.persist(livre);

        entityTransaction.commit();

        entityManager.close();
        entityManagerFactory.close();

        

    }

}
