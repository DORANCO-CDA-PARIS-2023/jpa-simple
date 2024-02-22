package doranco.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livre {
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

    public void setTitle(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

}
