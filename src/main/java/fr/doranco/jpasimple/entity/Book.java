package fr.doranco.jpasimple.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@NamedQuery(name = "findAll", query = "SELECT b FROM Book b")
@NamedQuery(name = "findByTitle", query = "SELECT b FROM Book b WHERE title LIKE :title")
@NamedQuery(name = "findByAuthor", query = "SELECT b FROM Book b WHERE CONCAT(author.lastname, ' ', author.name) LIKE :author")
@NamedQuery(name = "findByType", query = """
        SELECT b FROM Book b 
        JOIN BookCategory bc ON bc.name LIKE :type
        WHERE bc.name LIKE :type
        """)
@NamedQuery(name = "findByYearPublish", query = "SELECT b FROM Book b WHERE yearPublish = :yearPublish")
public final class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author", nullable = false)
    private Author author;
    private int yearPublish;
    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "book_category_id")
    )
    private List<BookCategory> bookCategories;
    @Column(name = "page_number")
    private int pageNumber;

    public Book() {
        this.bookCategories = new ArrayList<>();
    }

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<BookCategory> getBookCategories() {
        return bookCategories;
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

    public void addBookCategory(BookCategory bookCategory) {
        this.bookCategories.add(bookCategory);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", yearPublish=" + yearPublish +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
