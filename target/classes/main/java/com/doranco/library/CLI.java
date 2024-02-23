package com.doranco.library;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CLI {


        private final Scanner sc;


        public CLI() throws SQLException {
            sc = new Scanner(System.in);

        }

    public CLI(Scanner sc) {
        this.sc = sc;
    }
    BookDAO bookDao = new BookDAO();
    public void start()  {
            int cmd;
            do {
                printOption();
                cmd = sc.nextInt();
                switch (cmd) {
                    case 1:
                        displayBooks();
                        break;
                    case 2:
                        searchBookById();
                        break;
                    case 3:
                        addBook();
                        break;
                    case 4:
                        deleteBook();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            } while (cmd != 5);
            sc.close();
            System.out.println("Application fermée.");
        }

        private void displayBooks() {
            List<Book> books = bookDao.findAll();
            if (books != null) {
                for (Book book : books) {
                    System.out.println("ID : " + book.getId());
                    System.out.println("Title : " + book.getTitle());
                    System.out.println("Year : " + book.getYearPublication());
                    System.out.println("Author ID : " + book.getAuthor());
                    System.out.println("----------");
                }
            } else {
                System.out.println("Aucun livre trouvé.");
            }
        }

        private void searchBookById() {
            System.out.print("Entrez le titre du livre à rechercher : ");
            sc.nextLine(); // Pour consommer le saut de ligne
             long id = Long.parseLong(sc.nextLine());
            List<Book> books = (List<Book>) bookDao.findById(id);
            if (books != null) {
                for (Book book : books) {
                    System.out.println("ID : " + book.getId());
                    System.out.println("Title : " + book.getTitle());
                    System.out.println("Year : " + book.getYearPublication());
                    System.out.println("Author ID : " + book.getAuthor());
                    System.out.println("----------");
                }
            } else {
                System.out.println("Aucun livre trouvé avec le titre : " + id);
            }
        }

        private void addBook() {
            System.out.print("Entrez le titre du livre : ");
            sc.nextLine(); // Pour consommer le saut de ligne
            String title = sc.nextLine();
            System.out.print("Entrez l'année de publication : ");
            int year = sc.nextInt();
            System.out.print("Entrez l'ID de l'auteur : ");
            int authorId = sc.nextInt();
            Book book = new Book(title, year, authorId);
            bookDao.save(book);
            System.out.println("Livre ajouté avec succès !");
        }

        private void deleteBook() {
            System.out.print("Entrez l'ID du livre à supprimer : ");
            int id = sc.nextInt();
            bookDao.delete((long) id);
            System.out.println("Livre supprimé avec succès !");
        }
        private void printOption()
        {
            System.out.print(

                      " Option : "+
                            " - Display books"+
                            "2 - Search book (by title)"+
                            "3 - Create book"+
                            "4 - Delete book"+
                            "5 - exit "+
                        ">"
            );
        }

    }

