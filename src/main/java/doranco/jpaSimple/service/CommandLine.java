package doranco.jpaSimple.service;

import doranco.database.Database;
import doranco.jpaSimple.dao.LivreDaoImpl;
import doranco.jpaSimple.exception.NotFoundEntityException;
import fr.doranco.jpaSimple.entity.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLine {

	private Scanner sc;
	private LivreDaoImpl LivreDao;

//	private final Connection connection;
//	private final Statement statement;

	public CommandLine() throws SQLException {
		sc = new Scanner(System.in);
		LivreDao = new LivreDaoImpl();
	}

	public void start() throws SQLException, NotFoundEntityException {
		int cmd = 0;
		do {
			printOption();
			cmd = sc.nextInt();

			if (cmd == 1) {
				addLivre();
			} else if (cmd == 2) {
				displayLivres();
			} else if (cmd == 3) {
				searchByTitle();
			} else if (cmd == 4) {
				searchByAuthor();
			} else if (cmd == 5) {
				searchByGenre();
			} else if (cmd == 6) {
				searchByYear();
			} else if (cmd == 7) {
				displayTotalPagesByAuthor();
			} else if (cmd == 8) {
				updateLivre();
			} else if (cmd == 9) {
				deleteLivre();
			} else {
				System.out.println("Invalid option");
				start();
			}

		} while (cmd != 10);

		sc.close();
		System.out.println("Application closed");
	}

	private void addLivre() throws SQLException, NotFoundEntityException {

		System.out.print("Enter title : ");
		String title = sc.next();

		System.out.print("Enter genre : ");
		String genre = sc.next();

		System.out.print("Enter year : ");
		int year = sc.nextInt();

		System.out.print("Enter pages : ");
		int pages = sc.nextInt();

		Livre newLivre = new Livre(title, genre, year, pages);
		LivreDao.create(newLivre);
	}

	private void deleteLivre() {
		// TODO Auto-generated method stub

	}

	private void updateLivre() {
		// TODO Auto-generated method stub

	}

	private void displayTotalPagesByAuthor() {
		// TODO Auto-generated method stub

	}

	private void searchByYear() {
		// TODO Auto-generated method stub

	}

	private void searchByGenre() {
		// TODO Auto-generated method stub

	}

	private void searchByAuthor() {
		// TODO Auto-generated method stub

	}

	private void searchByTitle() {
		// TODO Auto-generated method stub

	}

	private void displayLivres() {
		// TODO Auto-generated method stub

	}

	private void printOption() {
		System.out.print("""
				Option :
				     1 - Ajouter un Livre
				     2 - Afficher tous les Livres
				     3 - Rechercher un Livre par Titre
				     4 - Rechercher un Livre par Auteur
				     5 - Rechercher un Livre par Genre
				     6- 	Rechercher un Livre par Année de Publication
				     7- 	Afficher le Nombre Total de Pages de Tous les Livres par autheur
				     8- 	Modiﬁer le Nombre de Pages d'un Livre
				     9- 	Supprimer un Livre
				     10- Quitter Le Programme
				 > """);

	}

}
