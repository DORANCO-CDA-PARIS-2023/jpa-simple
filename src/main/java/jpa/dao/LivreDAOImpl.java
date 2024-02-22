package jpa.dao;

import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jpa.entity.Livre;

public class LivreDAOImpl implements ILivreDAO {

	@Override
	public List<Livre> findAll(EntityManager em) throws Exception {
		TypedQuery<Livre> findAll = em.createQuery("SELECT l FROM Livre l", Livre.class);
		return findAll.getResultList();
	}

	@Override
	public Livre getById(EntityManager em, int id) throws Exception {
		TypedQuery<Livre> findById = em.createQuery("SELECT l FROM Livre l WHERE l.id = :id", Livre.class);
		findById.setParameter("id", id);
		return findById.getSingleResult();
	}

	@Override
	public void add(EntityManager em, Livre entity) throws SQLException, Exception {
		Query add = em.createNativeQuery("INSERT INTO books (title, author, genre, publishing_year, number_of_pages) VALUES (?, ?, ?, ?, ?)");
		add.setParameter(1, entity.getTitre());
		add.setParameter(2, entity.getAuteur());
		add.setParameter(3, entity.getGenre());
		add.setParameter(4, entity.getAnneePublication());
		add.setParameter(5, entity.getNombreDePages());
		add.executeUpdate();
		System.out.println("Livre ajouté.");
	}

	@Override
	public void remove(EntityManager em, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Livre> findByTitre(EntityManager em, String titre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> findByAuteur(EntityManager em, String auteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> findByGenre(EntityManager em, String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> findByAnneePublication(EntityManager em, int annee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalPages(EntityManager em, String auteur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Livre modifierNombrePages(EntityManager em, int idLivre, int nouveauNombre) {
		// TODO Auto-generated method stub
		return null;
	}



}
