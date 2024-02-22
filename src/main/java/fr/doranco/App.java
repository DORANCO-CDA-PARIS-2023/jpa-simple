package fr.doranco;

import jakarta.persistence.*;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        entityManager.close();
        entityManagerFactory.close();
    }
}
