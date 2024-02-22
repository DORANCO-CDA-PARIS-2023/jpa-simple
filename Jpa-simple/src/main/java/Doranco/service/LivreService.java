import java.util.List;

public interface LivreService {
    void ajouterLivre(String titre, String auteur, String genre, int anneePublication, int nombrePages);

    void afficherTousLesLivres();

    List<Livre> rechercherParTitre(String titre);

    List<Livre> rechercherParAuteur(String auteur);

    List<Livre> rechercherParGenre(String genre);

    List<Livre> rechercherParAnnee(int annee);

    void afficherTotalPagesParAuteur(String auteur);

    void modifierNombrePages(Long idLivre, int nouveauNombrePages);

    void supprimerLivre(Long idLivre);
}
