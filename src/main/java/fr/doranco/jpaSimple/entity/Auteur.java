package fr.doranco.jpaSimple.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Auteur")
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_author")
	private int id;

	@Column(name = "telephone")
	private String telephone;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;

	@OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
	private List<Livre> livres;

	public Auteur() {
		this.addresses = new ArrayList<>();
		this.livres = new ArrayList<>();
	}

	public Auteur(String telephone) {
		this.telephone = telephone;
		this.addresses = new ArrayList<>();
		this.livres = new ArrayList<>();
	}

	public Auteur(int id, String telephone) {
		this.id = id;
		this.telephone = telephone;
		this.addresses = new ArrayList<>();
		this.livres = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", telephone=" + telephone + ", user=" + user + ", addresses=" + addresses
				+ ", livres=" + livres + ", getUser()=" + getUser() + ", getAddresses()=" + getAddresses()
				+ ", getLivres()=" + getLivres() + "]";
	}
	
	

	

}
