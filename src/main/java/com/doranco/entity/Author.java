package com.doranco.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity @Table
public class Author {

	 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany (mappedBy = "author")
    private List<Livre> livres = new ArrayList<>();

    @OneToOne (cascade = CascadeType.ALL)
    private AuthorInformation information;

    public Author()
    {
    }

    public Author(String name)
    {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String login) {
        this.name = login;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public AuthorInformation getInformation() {
        return information;
    }

    public void setInformation(AuthorInformation information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", information=" + information +
                '}';
    }
}
