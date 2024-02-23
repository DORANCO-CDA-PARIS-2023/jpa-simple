package fr.doranco.jpaSimple.main;

import java.sql.SQLException;

import doranco.jpaSimple.exception.NotFoundEntityException;
import doranco.jpaSimple.service.CommandLine;
import fr.doranco.jpaSimple.entity.Address;
import fr.doranco.jpaSimple.entity.Auteur;
import fr.doranco.jpaSimple.entity.Livre;
import fr.doranco.jpaSimple.entity.User;


public class App {

	public static void main(String[] args) throws NotFoundEntityException {

//		var emf = Persistence.createEntityManagerFactory("CoursJpa");

//		try {
//			CommandLine commandLine = new CommandLine();
//			commandLine.start();
//		} catch (SQLException e) {
//			System.err.println(e);
//		}
		
		User user_1 = new User("toto", "tata", "toto@tata.com", "1234");
		User user_2 = new User("titi", "tutu", "titi@tutu.com", "5678");
		User user_3 = new User("bobo", "baba", "bobo@baba.com", "91011");
		
		Address address_1 = new Address(1, "rue de la paix", "Paris", 75000, "France");
		Address address_2 = new Address(2, "rue de la joie", "Lyon", 69000, "France");
		Address address_3 = new Address(3, "rue de la tristesse", "Marseille", 13000, "France");
		
		Auteur auteur_1 = new Auteur("1234567890");
		Auteur auteur_2 = new Auteur("0987654321");
		Auteur auteur_3 = new Auteur("1357924680");
		
		Livre livre_1 = new Livre("titre_1", "genre_1", 2021, 100);
		Livre livre_2 = new Livre("titre_2", "genre_2", 2022, 200);
		Livre livre_3 = new Livre("titre_3", "genre_3", 2023, 300);
		Livre livre_4 = new Livre("titre_4", "genre_4", 2024, 400);
		Livre livre_5 = new Livre("titre_5", "genre_5", 2025, 500);
		Livre livre_6 = new Livre("titre_6", "genre_6", 2026, 600);
		
		
		auteur_1.setUser(user_1);
		auteur_1.getAddresses().add(address_1);
		auteur_1.getLivres().add(livre_1);
		auteur_1.getLivres().add(livre_2);
		
		auteur_2.setUser(user_2);
		auteur_2.getAddresses().add(address_2);
		auteur_2.getLivres().add(livre_3);
		auteur_2.getLivres().add(livre_4);
		
		auteur_3.setUser(user_3);
		auteur_3.getAddresses().add(address_3);
		auteur_3.getLivres().add(livre_5);
		auteur_3.getLivres().add(livre_6);
		
		
		System.out.println(livre_1);
		System.out.println(livre_2);
		System.out.println(livre_3);
		System.out.println(livre_4);
		System.out.println(livre_5);
		System.out.println(livre_6);
		
		System.out.println(auteur_1);
		System.out.println(auteur_2);
		System.out.println(auteur_3);
		
		

	}

}
