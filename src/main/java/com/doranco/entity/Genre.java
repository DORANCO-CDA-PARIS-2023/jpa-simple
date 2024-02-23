package com.doranco.entity;
import jakarta.persistence.*;

import java.sql.Date;

@Entity @Table
public class Genre {

	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	    private String name;
	
		public Long getId() {
			return id;
		}
		
		public Genre( String name) {
			super();
			this.name = name;
			
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
		
		
		@Override
		public String toString() {
			return "Author [id=" + id + ", name=" + name + " ]";
		}
	  
}
