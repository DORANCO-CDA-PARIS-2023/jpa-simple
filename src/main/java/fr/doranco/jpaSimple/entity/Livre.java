package fr.doranco.jpaSimple.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_book")
	private int id;

	@Column(name = "titre")
	private String titre;

	@Column(name = "genre")
	private String genre;

	@Column(name = "anneePublication")
	private int anneePublication;

	@Column(name = "nombrePages")
	private int nombrePages;

	@Column(name = "auteur")
	private String auteur;

	public Livre() {
	}

	public Livre(String titre, String genre, int anneePublication, int nombrePages, String auteur) {
		this.titre = titre;
		this.genre = genre;
		this.anneePublication = anneePublication;
		this.nombrePages = nombrePages;
		this.auteur = auteur;
	}

	public Livre(int id, String titre, String genre, int anneePublication, int nombrePages, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.genre = genre;
		this.anneePublication = anneePublication;
		this.nombrePages = nombrePages;
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
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

	public int getNombrePages() {
		return nombrePages;
	}

	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", genre=" + genre + ", anneePublication=" + anneePublication
				+ ", nombrePages=" + nombrePages + ", auteur=" + auteur + "]";
	}

}
