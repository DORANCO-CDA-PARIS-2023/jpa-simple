package jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Auteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "author_id")
	Long id;
	
	 @Column(name = "firstname")
	String firstname;
	 
	 @Column(name = "lastname")
	String lastname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	 
	 
	
}
