package fr.doranco.jpasimple.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_category")
@NamedQuery(name = "findByName", query = "SELECT bc FROM BookCategory bc WHERE name LIKE :name")
public final class BookCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "bookCategories", cascade = CascadeType.ALL)
    private List<Book> books;

    public BookCategory() {
        this.books = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
