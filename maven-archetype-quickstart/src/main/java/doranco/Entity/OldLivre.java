package doranco.Entity;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l"),
        @NamedQuery(name = "Livre.findByTitre", query = "SELECT l FROM Livre l WHERE l.titre LIKE :titre"),
        @NamedQuery(name = "Livre.findByAuteur", query = "SELECT l FROM Livre l WHERE l.auteur = :auteur"),
        @NamedQuery(name = "Livre.findByGenre", query = "SELECT l FROM Livre l WHERE l.genre = :genre"),
        @NamedQuery(name = "Livre.findByAnneePublication", query = "SELECT l FROM Livre l WHERE l.anneePublication = :anneePublication"),
        @NamedQuery(name = "Livre.findByNombrePages", query = "SELECT l FROM Livre l WHERE l.nombrePages = :nombrePages")
})

@Table(name = "livre")
public class OldLivre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @Column(name = "genre")
    private String genre;

    @Column(name = "anneePublication")
    private Integer anneePublication;

    @Column(name = "nombrePages")
    private Integer nombrePages;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(Integer anneePublication) {
        this.anneePublication = anneePublication;
    }

    public Integer getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(Integer nombrePages) {
        this.nombrePages = nombrePages;
    }

}
