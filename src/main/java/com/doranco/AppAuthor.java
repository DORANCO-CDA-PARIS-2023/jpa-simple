package com.doranco;

import java.time.LocalDate;
import java.util.List;

import com.doranco.entity.Author;
import com.doranco.entity.Livre;
import com.doranco.service.AuthorService;
import com.doranco.service.LivreService;

import jakarta.persistence.Persistence;

public class AppAuthor {

	public static void main(String[] args) {
	     try (var ef = Persistence.createEntityManagerFactory("Create Authors")) {
	            var manager = ef.createEntityManager();

	            AuthorService service = new AuthorService(manager);

	            service.create(new Author("victor", "hugo", LocalDate.of(1988, 12, 24)));
	            service.create(new Author("AUthor", "2", LocalDate.of(1988, 12, 24)));
	            service.create(new Author("author", "3", LocalDate.of(1988, 12, 24)));
	            service.create(new Author("author", "4", LocalDate.of(1988, 12, 24)));

	            
	            

	            manager.close();
	        }
	    }
	}