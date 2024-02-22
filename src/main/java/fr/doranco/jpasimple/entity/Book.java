package fr.doranco.jpasimple.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
@NamedQuery(name = "findByTitle", query = "SELECT b FROM Book b WHERE title LIKE :title")
@NamedQuery(name = "findByAuthor", query = "SELECT b FROM Book b WHERE author LIKE :author")
@NamedQuery(name = "findByType", query = "SELECT b FROM Book b WHERE type LIKE :type")
@NamedQuery(name = "findByYearPublish", query = "SELECT b FROM Book b WHERE yearPublish = :yearPublish")
public final class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "year_publish")
    private int yearPublish;
    @Column(name = "type")
    private String type;
    @Column(name = "page_number")
    private int pageNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublish=" + yearPublish +
                ", type='" + type + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
