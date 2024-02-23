package dao;

import java.util.List;

import javax.persistence.EntityManager;
import entity.Livre;

public interface ILivreDao extends ICrud<Livre> {
	
	public List<Livre> findByTitre(EntityManager em, String titre);
	public List<Livre> findByAuteur(EntityManager em, String auteur);
	public List<Livre> findByGenre(EntityManager em, String genre);
	public List<Livre> findByAnneePublication(EntityManager em, int annee);
	public void modifierNombrePages(EntityManager em, int idLivre, int nouveauNombre);

}
