package doranco.jpaSimple.dao;

import doranco.database.Database;
import doranco.jpaSimple.exception.NotFoundEntityException;
import fr.doranco.jpaSimple.entity.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreDaoImpl implements ILivreDao {

	private final Connection connection;
	private final Statement statement;
	private final EntityManagerFactory emf;

	public LivreDaoImpl() throws SQLException {
		connection = Database.getINSTANCE().getConnection();
		statement = connection.createStatement();
		emf = Persistence.createEntityManagerFactory("CoursJpa");
	}

	@Override
	public Livre find(int id) throws SQLException, NotFoundEntityException {
		String query = "SELECT * FROM Livre WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		if (result.next()) {
			return new Livre(result.getInt("id"), result.getString("titre"), result.getString("genre"),
					result.getInt("anneePublication"), result.getInt("nombrePages"), result.getString("auteur"));
		}
		throw new NotFoundEntityException("id : " + id + " doesn't exist");
	}

	@Override
	public List<Livre> findAll() throws SQLException {
		String query = "SELECT * FROM Livre";
		ResultSet result = statement.executeQuery(query);
		List<Livre> Livres = new ArrayList<>();

		while (result.next()) {
			Livre Livre = new Livre();
			Livre.setId(result.getInt("id"));
			Livre.setTitre(result.getString("titre"));
			Livre.setGenre(result.getString("genre"));
			Livre.setAnneePublication(result.getInt("anneePublication"));
			Livre.setNombrePages(result.getInt("nombrePages"));
			Livre.setAuteur(result.getString("auteur"));

			Livres.add(Livre);
			/*
			 * Livres.add(new Livre( result.getInt("id"), result.getString("title"),
			 * result.getInt("year_publish"), result.getInt("id_author") ));
			 */
		}
		return Livres.isEmpty() ? null : Livres;
	}

	@Override
	public void create(Livre Livre) throws SQLException, NotFoundEntityException {
		
		try (EntityManager em = emf.createEntityManager()) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			// Opérations CRUD avec la classe Employee
			Livre newLivre = new Livre(Livre.getTitre(), Livre.getGenre(), Livre.getAnneePublication(),
                    Livre.getNombrePages(), Livre.getAuteur());
			em.persist(newLivre); // Create
//			Employee retrievedEmployee = em.find(Employee.class, 1L); // Read
//			retrievedEmployee.setDepartment("HR");
//			em.merge(retrievedEmployee); // Update
//			em.remove(retrievedEmployee); // Delete
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			emf.close();
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		String query = "DELETE FROM Livre WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.execute();
	}

	@Override
	public List<Livre> searchByTitle(String title) throws SQLException {
		String query = "SELECT * FROM Livre WHERE title LIKE ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, "%" + title + "%");
		ResultSet result = statement.executeQuery();

		List<Livre> Livres = new ArrayList<>();
		while (result.next()) {
			Livres.add(new Livre(result.getInt("id"), result.getString("titre"), result.getString("genre"),
					result.getInt("anneePublication"), result.getInt("nombrePages"), result.getString("auteur")));
		}
		return Livres.isEmpty() ? null : Livres;
	}
}
