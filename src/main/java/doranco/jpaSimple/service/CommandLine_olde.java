package doranco.jpaSimple.service;

import doranco.database.Database;
import doranco.jpaSimple.dao.LivreDaoImpl;
import doranco.jpaSimple.exception.NotFoundEntityException;
import fr.doranco.jpaSimple.entity.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLine_olde {

    private Scanner sc;
    private LivreDaoImpl LivreDao;
    
	private final Connection connection;
	private final Statement statement;


    public CommandLine_olde() throws SQLException {
        sc = new Scanner(System.in);
        LivreDao = new LivreDaoImpl();
        connection = Database.getINSTANCE().getConnection();
		statement = connection.createStatement();
    }

    public void start() throws SQLException, NotFoundEntityException {
        int cmd = 0;
        do {
            printOption();
            cmd = sc.nextInt();

            switch (cmd) {
                case 1 -> displayLivres();
                case 2 -> {
                    System.out.print("Enter title : ");
                    String title = sc.next();
                	searchByTitle(title);
                }
                case 3 -> {
                    System.out.print("Enter title : ");
                    String title = sc.next();
                    System.out.print("Enter year : ");
                    int year = sc.nextInt();
                    System.out.print("Enter author ID : ");
                    int authorId = sc.nextInt();
                    
                    createLivre(new Livre(title, year, authorId));
                }
                case 4 -> {
                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();
                    deleteLivre(id);
                }
                default -> { System.out.println("Invalid option");
                start();}
            }
        } while (cmd != 5);
        
        sc.close();
        System.out.println("Application closed");
    }

    private void displayLivres() throws SQLException {
        List<Livre> Livres = LivreDao.findAll();
        for (Livre Livre: Livres)
        {
            System.out.print("ID : " + Livre.getId());
            System.out.print("\tTitle : " + Livre.getTitle());
            System.out.print("\tYear : " + Livre.getYear());
            System.out.println("\tAuthor ID : " + Livre.getAuthorId());
            System.out.println("----------");
        }
    }
    
    public List<Livre> searchByTitle(String title) throws SQLException {
        String query = "SELECT * FROM Livre WHERE title LIKE ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + title + "%");
        ResultSet result = statement.executeQuery();

        List<Livre> Livres = new ArrayList<>();
        while (result.next())
        {
            Livres.add(new Livre(
                    result.getInt("id"),
                    result.getString("title"),
                    result.getInt("year_publish"),
                    result.getInt("id_author")
            ));
        }
        for (Livre Livre: Livres)
        {
            System.out.print("ID : " + Livre.getId());
            System.out.print("\tTitle : " + Livre.getTitle());
            System.out.print("\tYear : " + Livre.getYear());
            System.out.println("\tAuthor ID : " + Livre.getAuthorId());
            System.out.println("----------");
        }
        return Livres.isEmpty() ? null : Livres;
    }
    
    
	public void createLivre(Livre Livre) throws SQLException, NotFoundEntityException {
		String query = """
				    INSERT INTO Livre (title, year_publish, id_author)
				    VALUE (?, ?, ?)
				""";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, Livre.getTitle());
		statement.setInt(2, Livre.getYear());
		statement.setInt(3, Livre.getAuthorId());
		try {
			statement.execute();
		} catch (SQLException e) {
			throw new NotFoundEntityException("Author ID : " + Livre.getAuthorId() + " doesn't exist");
		}
	}
	
	
	public void deleteLivre(int id) throws SQLException {
        String query = "DELETE FROM Livre WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.execute();
    }

    private void printOption()
    {
        System.out.print(
                """
                   Option : 
                        1 - Display Livres
                        2 - Search Livre (by title)
                        3 - Create Livre
                        4 - Delete Livre
                        5 - exit 
                    > """
        );
    }

}
