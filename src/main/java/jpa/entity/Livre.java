package jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//toutes les annotations à importer sont de jakarta.persistence
@Entity
@Table(name = "books")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")
	 private Long id;
	
	 @Column(name = "title")
	 private String titre;
	 
	 @Column(name = "author")
	 private String auteur;
	 
	 @Column(name = "genre")
	 private String genre;
	 
	 @Column(name = "publishing_year")
	 private int anneePublication;
	 
	 @Column(name = "number_of_pages")
	 private int nombreDePages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAnneePublication() {
		return anneePublication;
	}

	public void setAnneePublication(int anneePublication) {
		this.anneePublication = anneePublication;
	}

	public int getNombreDePages() {
		return nombreDePages;
	}

	public void setNombreDePages(int nombreDePages) {
		this.nombreDePages = nombreDePages;
	}
	 
	 

}
