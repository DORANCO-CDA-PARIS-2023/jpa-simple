package entity;

import javax.persistence.*;

@Entity @Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "titre")
    private String titre;
    
    @ManyToOne
	@JoinColumn(name = "author_id")
    private Auteur auteur;
    
    @ManyToOne
	@JoinColumn(name = "genre_id")
    private Genre genre;
    
    @Column(name = "annee_publication")
    private int anneePublication;
    
    @Column(name = "nombre_page")
    private int nombrePages;

    public Livre() {}

    public Livre(String titre, int anneePublication, int nombrePages) {
        this.titre = titre;        
        this.anneePublication = anneePublication;
        this.nombrePages = nombrePages;
    }

    public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

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

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }
    
    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + titre + '\'' +
                ", author='" + auteur + '\'' +
                ", genre='" + genre + '\'' +
                ", yearPublish=" + anneePublication +
                ", pageNumber=" + nombrePages +
                '}';
    }
}