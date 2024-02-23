package com.doranco.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity	
@Table(name ="auteur")

public class Auteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_auteur")	
		private int id;
		
		@Column(name="nom")
		private String nom;
		
		@Column(name="prenom")
		private String prenom;

		
		public Auteur() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Auteur(String nom, String prenom) {
			super();
			this.nom = nom;
			this.prenom = prenom;
		}
		@OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
		private List<Livre> livres;


		public List<Livre> getLivres() {
			return livres;
		}

		public void setLivres(List<Livre> livres) {
			this.livres = livres;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
		}
		
		
}
