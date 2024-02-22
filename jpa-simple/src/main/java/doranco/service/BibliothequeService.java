package doranco.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

import doranco.entity.Livre;

public class BibliothequeService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BibliothequeService() {
        emf = Persistence.createEntityManagerFactory("CoursJpa");
        em = emf.createEntityManager();
    }

    public void ajouterLivre(String titre, String auteur, String genre, int anneePublication, int nombrePages) {
        em.getTransaction().begin();

        Livre livre = new Livre();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setGenre(genre);
        livre.setAnneePublication(anneePublication);
        livre.setNombrePages(nombrePages);

        em.persist(livre);

        em.getTransaction().commit();
    }
    
    public void afficher() {
        List<Livre> livres = em.createQuery("SELECT l FROM Livre l", Livre.class).getResultList();
        for (Livre livre : livres) {
            System.out.println(livre.getId() + ": " + livre.getTitre() + " - " + livre.getAuteur());
        }
    }

    public void rechercherTitre(String titre) {
        Query query = em.createQuery("SELECT l FROM Livre l WHERE l.titre = :titre", Livre.class);
        query.setParameter("titre", titre);
        List<Livre> livres = query.getResultList();

        if (!livres.isEmpty()) {
            for (Livre livre : livres) {
                System.out.println(livre.getId() + ": " + livre.getTitre() + " - " + livre.getAuteur());
            }
        } else {
            System.out.println("Aucun livre trouvé avec le titre : " + titre);
        }
    }
    
    public void rechercherAuteur(String auteur) {
        Query query = em.createQuery("SELECT l FROM Livre l WHERE l.auteur = :auteur", Livre.class);
        query.setParameter("auteur", auteur);
        List<Livre> livres = query.getResultList();

        if (!livres.isEmpty()) {
            for (Livre livre : livres) {
                System.out.println(livre.getId() + ": " + livre.getTitre() + " - " + livre.getAuteur());
            }
        } else {
            System.out.println("Aucun livre trouvé avec l'auteur : " + auteur);
        }
    }
    
    public void rechercherGenre(String genre) {
        Query query = em.createQuery("SELECT l FROM Livre l WHERE l.genre = :genre", Livre.class);
        query.setParameter("genre", genre);
        List<Livre> livres = query.getResultList();

        if (!livres.isEmpty()) {
            for (Livre livre : livres) {
                System.out.println(livre.getId() + ": " + livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getGenre());
            }
        } else {
            System.out.println("Aucun livre trouvé avec le genre : " + genre);
        }
    }

    public void rechercherAnnee(int annee) {
        Query query = em.createQuery("SELECT l FROM Livre l WHERE l.anneePublication = :annee", Livre.class);
        query.setParameter("annee", annee);
        List<Livre> livres = query.getResultList();

        if (!livres.isEmpty()) {
            for (Livre livre : livres) {
                System.out.println(livre.getId() + ": " + livre.getTitre() + " - " + livre.getAuteur() + " - " + livre.getAnneePublication());
            }
        } else {
            System.out.println("Aucun livre trouvé avec l'année de publication : " + annee);
        }
    }

    public void totalPages(String auteur) {
        Query query = em.createQuery("SELECT SUM(l.nombrePages) FROM Livre l WHERE l.auteur = :auteur", Long.class);
        query.setParameter("auteur", auteur);
        Long total = (Long) query.getSingleResult();

        if (total != null) {
            System.out.println("Le nombre total de pages pour l'auteur " + auteur + " est : " + total);
        } else {
            System.out.println("Aucun livre trouvé pour l'auteur : " + auteur);
        }
    }

    public void modifierPages(Long idLivre, int nouveauNombrePages) {
        em.getTransaction().begin();

        Livre livre = em.find(Livre.class, idLivre);

        if (livre != null) {
            livre.setNombrePages(nouveauNombrePages);
            em.merge(livre);
            em.getTransaction().commit();
            System.out.println("Nombre de pages du livre avec l'id " + idLivre + " modifié avec succès !");
        } else {
            em.getTransaction().rollback();
            System.out.println("Aucun livre trouvé avec l'id : " + idLivre);
        }
    }

    public void supprimer(Long idLivre) {
        em.getTransaction().begin();

        Livre livre = em.find(Livre.class, idLivre);

        if (livre != null) {
            em.remove(livre);
            em.getTransaction().commit();
            System.out.println("Livre avec l'id " + idLivre + " supprimé avec succès !");
        } else {
            em.getTransaction().rollback();
            System.out.println("Aucun livre trouvé avec l'id : " + idLivre);
        }
    }

    public void quitter() {
        em.close();
        emf.close();
    }
}
