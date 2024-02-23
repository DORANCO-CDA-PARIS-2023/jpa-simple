package jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	 
	 @ManyToOne
	 @JoinColumn(name = "author_id")
	 private Auteur auteur;
	 
	 @ManyToOne
	 @JoinColumn(name = "genre_id")
	 private Genre genre;
	 
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
