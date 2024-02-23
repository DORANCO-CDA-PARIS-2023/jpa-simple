package com.doranco.entity;

import jakarta.persistence.*;

@Entity	
@Table(name ="livre")
public class Livre {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_livre")
private int id;

@Column(name = "titre")
private String titre;

@ManyToOne
@JoinColumn(name = "id_auteur", unique = true)
private Auteur auteur;


@Column(name = "genre")
private String genre;

@Column(name="annee_publication")
private int annee_publication;

@Column(name="nombre_pages")
private int nombre_page;

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public Auteur getAuteur() {
	return getAuteur();
}

public void setAuteur(Auteur auteur) {
	this.auteur = auteur;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public int getAnnee_publication() {
	return annee_publication;
}

public void setAnnee_publication(int annee_publication) {
	this.annee_publication = annee_publication;
}

public int getNombre_page() {
	return nombre_page;
}

public void setNombre_page(int nombre_page) {
	this.nombre_page = nombre_page;
}

public int getId() {
	return id;
}

@Override
public String toString() {
	return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", genre=" + genre + ", annee_publication="
			+ annee_publication + ", nombre_page=" + nombre_page + "]";
}


	
}
