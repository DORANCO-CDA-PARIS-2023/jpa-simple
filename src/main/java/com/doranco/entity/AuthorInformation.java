package com.doranco.entity;

import jakarta.persistence.*;

@Entity @Table
public class AuthorInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fistname;
    private String lastname;


    public AuthorInformation() {}

    public AuthorInformation(String fistname, String lastname) {
        this.fistname = fistname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "AuthorInformation{" +
                "id=" + id +
                ", fistname='" + fistname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
