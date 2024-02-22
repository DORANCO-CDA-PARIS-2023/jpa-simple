package com.doranco;


import com.doranco.library.Book;
import com.doranco.library.BookDAO;

class App {
    public static void main(String[] args) {
        // Create a BookDAO instance
        BookDAO bookDAO = new BookDAO();

        // Create and save a new book
        Book book1 = new Book("2","Author1","Poems",1999,85);
        book1.setTitle("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        Book book2=new Book("CatTrap","Nia.T","Story",2023,150);
        bookDAO.save(book2);
        bookDAO.save(book1);
        System.out.println("Book saved: " + book1);

        // Find a book by its ID
        Long bookId = book1.getId();
        Book foundBook = bookDAO.findById(bookId);
        System.out.println("Found book by ID " + bookId + ": " + foundBook);

        // Update the book's title
        foundBook.setTitle("The Catcher in the Rye");
        bookDAO.update(foundBook);
        System.out.println("Updated book: " + foundBook);

        // Find all books
        System.out.println("All books:");
        bookDAO.findAll().forEach(System.out::println);

        // Delete the book
        bookDAO.delete(bookId);
        System.out.println("Book deleted");

        // Find all books after deletion
        System.out.println("All books after deletion:");
        bookDAO.findAll().forEach(System.out::println);
    }
}
