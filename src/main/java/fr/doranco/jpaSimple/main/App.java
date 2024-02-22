package fr.doranco.jpaSimple.main;

import java.sql.SQLException;

import doranco.jpaSimple.exception.NotFoundEntityException;
import doranco.jpaSimple.service.CommandLine;


public class App {

	public static void main(String[] args) throws NotFoundEntityException {

//		var emf = Persistence.createEntityManagerFactory("CoursJpa");

		try {
			CommandLine commandLine = new CommandLine();
			commandLine.start();
		} catch (SQLException e) {
			System.err.println(e);
		}

	}

}
