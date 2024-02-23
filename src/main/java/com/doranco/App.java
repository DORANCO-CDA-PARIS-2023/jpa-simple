package com.doranco;

import com.doranco.entity.Author;
import com.doranco.entity.AuthorInformation;
import com.doranco.entity.Livre;
import com.doranco.service.LivreService;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        try (var ef = Persistence.createEntityManagerFactory("correctionTp3")) {
            var manager = ef.createEntityManager();

            LivreService service = new LivreService(manager);

            AuthorInformation informationBob = new AuthorInformation("Robert", "Dupont");
            AuthorInformation informationTiti = new AuthorInformation("Paul", "M");
            AuthorInformation informationToto = new AuthorInformation("Alice", "O");

            Author bob = new Author("Bob");
            bob.setInformation(informationBob);
            Author titi = new Author("Titi");
            titi.setInformation(informationTiti);
            Author toto = new Author("toto");
            toto.setInformation(informationToto);

            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();

            manager.persist(informationBob);
            manager.persist(informationToto);
            manager.persist(informationTiti);

            manager.persist(bob);
            manager.persist(titi);
            manager.persist(toto);
            transaction.commit();

            //TODO
            System.out.println(bob);

            service.create(new Livre("super titre", bob, "SF", 1900, 100));
            service.create(new Livre("titre2", bob, "SF", 1960, 100));
            service.create(new Livre("titre 3", titi, "Horror", 2000, 100));
            service.create(new Livre("Titre 4", toto, "Fantasy", 2010, 100));

           // Author author = manager.find(Author.class, 1L);
//            System.out.println(author);
//            List<Livre> livres = author.getLivres();
//            for (Livre livre : livres)
//            {
//                System.out.println(livre);
//            }

            manager.close();
        }
    }
}
