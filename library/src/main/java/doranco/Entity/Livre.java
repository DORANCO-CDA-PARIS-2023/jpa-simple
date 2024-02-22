package doranco.Entity;

import javax.annotation.processing.Generated;

@Entity
@table(name = "employees")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "auteur")
    private String auteur;
    @Column(name = "genre")
    private String genre;

    @Column(name = "annee_publication")
    private int anneePublication;

    @Colmn(name = "nombre_pages")
    private int nombrePages;
}
