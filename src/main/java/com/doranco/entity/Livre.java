package com.doranco.entity;

import jakarta.persistence.*;

@Entity @Table
public class Livre {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    private String genre;
    private int yearPublish;
    private int pageNumber;


    public Livre() {}

    public Livre(String title, Author author, String genre, int yearPublish, int pageNumber) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublish = yearPublish;
        this.pageNumber = pageNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearPublish=" + yearPublish +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
