package com.doranco.entity;
import jakarta.persistence.*;


import java.time.LocalDate;
@Entity @Table
public class Author {

	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	    private String name;
	    private String firstname;
	    private LocalDate birthday;
		public Long getId() {
			return id;
		}
		
		public Author( String name, String firstname, LocalDate birthday) {
			super();
			this.name = name;
			this.firstname = firstname;
			this.birthday = birthday;
		}
		
		

		public LocalDate getBirthday() {
			return birthday;
		}

		public void setBirthday(LocalDate birthday) {
			this.birthday = birthday;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		
		@Override
		public String toString() {
			return "Author [id=" + id + ", name=" + name + ", firstname=" + firstname + ", birthday=" + birthday + "]";
		}
	  
}
