package jpa.dao;

import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jpa.aggregation.TotalPageResult;
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
		TypedQuery<Livre> remove = em.createQuery("DELETE FROM Livre l WHERE l.id = :id", Livre.class);
		remove.executeUpdate();
	}

	@Override
	public List<Livre> findByTitre(EntityManager em, String titre) {
		TypedQuery<Livre> findByTitle = em.createQuery("SELECT l FROM Livre l WHERE l.title LIKE :title", Livre.class);
		findByTitle.setParameter("title", "%" + titre + "%");
		return findByTitle.getResultList();
	}

	@Override
	public List<Livre> findByAuteur(EntityManager em, String auteur) {
		TypedQuery<Livre> findByAuthor = em.createQuery("SELECT l FROM Livre l WHERE l.author LIKE :author", Livre.class);
		findByAuthor.setParameter("author", "%" + auteur + "%");
		return findByAuthor.getResultList();
	}

	@Override
	public List<Livre> findByGenre(EntityManager em, String genre) {
		TypedQuery<Livre> findByGenre = em.createQuery("SELECT l FROM Livre l WHERE l.genre LIKE :genre", Livre.class);
		findByGenre.setParameter("genre", "%" + genre + "%");
		return findByGenre.getResultList();
	}

	@Override
	public List<Livre> findByAnneePublication(EntityManager em, int annee) {
		TypedQuery<Livre> findByYear = em.createQuery("SELECT l FROM Livre l WHERE l.publishing_year = :year", Livre.class);
		findByYear.setParameter("year", annee);
		return findByYear.getResultList();
	}

	@Override
	public Long totalPages(EntityManager em, String auteur) {
		TypedQuery<TotalPageResult> countTotalPages = em.createQuery("SELECT new jpa.aggregation.TotalPageResult(l.auteur, SUM(l.nombreDePages)) FROM Livre l WHERE l.auteur LIKE :author", TotalPageResult.class);
		countTotalPages.setParameter("author", "%" + auteur + "%");
		return countTotalPages.getSingleResult().getTotalPages();
	}

	@Override
	public void modifierNombrePages(EntityManager em, int idLivre, int nouveauNombre) {
		Query setNumberOfPages = em.createQuery(" UPDATE Livre SET nombreDePages = :nouveauNombre WHERE id = :idLivre");
		setNumberOfPages.setParameter("nouveauNombre", nouveauNombre);
		setNumberOfPages.setParameter("idLivre", idLivre);
		setNumberOfPages.executeUpdate();
	}



}
