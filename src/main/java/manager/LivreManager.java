package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import entity.Livre;

public class LivreManager {
	private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LivreManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-simple");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public void afficherResultatsRecherche(List<Livre> resultats) {
        if (resultats.isEmpty()) {
            System.out.println("Aucun livre trouvé.");
        } else {
            System.out.println("Résultats de la recherche :");
            for (Livre livre : resultats) {
                System.out.println(livre);
            }
        }
    }
    
    public void afficherLivres() {
        TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l", Livre.class);
        List<Livre> livres = query.getResultList(); // Utiliser la liste resultante de la requête
        for (Livre livre : livres) {
            System.out.println(livre);
        }
    }

    public void ajouterLivre(String titre, String auteur, String genre, int anneePublication, int nombrePages) {
        entityManager.getTransaction().begin();
        Livre livre = new Livre(titre, auteur, genre, anneePublication, nombrePages);
        entityManager.persist(livre);
        entityManager.getTransaction().commit();
    }

    public void rechercherParTitre(String titre) {
        TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.titre = :titre", Livre.class);
        query.setParameter("titre", titre);
        List<Livre> result = query.getResultList();
        afficherResultatsRecherche(result);
    }

    public void rechercherParAuteur(String auteur) {
        TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.auteur = :auteur", Livre.class);
        query.setParameter("auteur", auteur);
        List<Livre> result = query.getResultList();
        afficherResultatsRecherche(result);
    }

    public void rechercherParGenre(String genre) {
        TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.genre = :genre", Livre.class);
        query.setParameter("genre", genre);
        List<Livre> result = query.getResultList();
        afficherResultatsRecherche(result);
    }
    
    public void rechercherParAnnee(int annee) {
        TypedQuery<Livre> query = entityManager.createQuery("SELECT l FROM Livre l WHERE l.anneePublication = :annee", Livre.class);
        query.setParameter("annee", annee);
        List<Livre> result = query.getResultList();
        afficherResultatsRecherche(result);
    }
    
    public void afficherTotalPagesParAuteur(String auteur) {
        TypedQuery<Integer> query = entityManager.createQuery("SELECT SUM(l.nombrePages) FROM Livre l WHERE l.auteur = :auteur", Integer.class);
        query.setParameter("auteur", auteur);
        Integer totalPages = query.getSingleResult();
        System.out.println("Nombre total de pages des livres de " + auteur + " : " + totalPages);
    }
    
    public void modifierNombrePages(long idLivre, int nouveauNombrePages) {
        entityManager.getTransaction().begin();
        Livre livre = entityManager.find(Livre.class, idLivre);
        if (livre != null) {
            livre.setNombrePages(nouveauNombrePages);
            entityManager.getTransaction().commit();
            System.out.println("Nombre de pages du livre avec l'ID " + idLivre + " modifié avec succès.");
        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Livre avec l'ID " + idLivre + " non trouvé.");
        }
    }
    
    public void supprimerLivre(long idLivre) {
        entityManager.getTransaction().begin();
        Livre livre = entityManager.find(Livre.class, idLivre);
        if (livre != null) {
            entityManager.remove(livre);
            entityManager.getTransaction().commit();
            System.out.println("Livre avec l'ID " + idLivre + " supprimé avec succès.");
        } else {
            entityManager.getTransaction().rollback();
            System.out.println("Livre avec l'ID " + idLivre + " non trouvé.");
        }
    }
    
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}