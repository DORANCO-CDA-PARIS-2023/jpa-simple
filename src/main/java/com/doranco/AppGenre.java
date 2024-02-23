package com.doranco;

import java.util.List;

import com.doranco.entity.Genre;
import com.doranco.service.GenreService;


import jakarta.persistence.Persistence;

public class AppGenre {

	public static void main(String[] args) {
	     try (var ef = Persistence.createEntityManagerFactory("Create Genre")) {
	            var manager = ef.createEntityManager();

	            GenreService service = new GenreService(manager);

	            service.create(new Genre("comedie"));
	            service.create(new Genre("Action"));
	            service.create(new Genre("Mafia"));
	            service.create(new Genre("Sport"));


	            manager.close();
	        }
	    }
	}