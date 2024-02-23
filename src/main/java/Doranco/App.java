package com.doranco;

import com.doranco.entity.Livre;
import com.doranco.service.LivreService;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try (var ef = Persistence.createEntityManagerFactory("correctionTp3")) {
            var manager = ef.createEntityManager();

            LivreService service = new LivreService(manager);

            service.create(new Livre("super titre", "Bob", "SF", 1900, 100));
            service.create(new Livre("titre2", "Bob", "SF", 1960, 100));
            service.create(new Livre("titre 3", "titi", "Horror", 2000, 100));
            service.create(new Livre("Titre 4", "toto", "Fantasy", 2010, 100));

            List<Livre> livres = service.findByAuthor("bob");
            for (Livre livre : livres) {
                System.out.println(livre);
            }

            manager.close();
        }
    }
}