package jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.entity.Livre;

public interface ILivreDAO extends ICrud<Livre> {
	public List<Livre> findByTitre(EntityManager em, String titre);
	public List<Livre> findByAuteur(EntityManager em, String auteur);
	public List<Livre> findByGenre(EntityManager em, String genre);
	public List<Livre> findByAnneePublication(EntityManager em, int annee);
	public Long totalPages(EntityManager em, String auteur);
	public void modifierNombrePages(EntityManager em, int idLivre, int nouveauNombre);


}
