package Doranco;

import java.util.List;

public interface LivreDAO {
    void ajouterLivre(Livre livre);

    Livre rechercherParId(Long id);

    List<Livre> rechercherParTitre(String titre);

    List<Livre> rechercherParAuteur(String auteur);

    List<Livre> rechercherParGenre(String genre);

    List<Livre> rechercherParAnnee(int annee);

    void modifierNombrePages(Long idLivre, int nouveauNombrePages);

    void supprimerLivre(Long idLivre);

    int getTotalPagesParAuteur(String auteur);
}
