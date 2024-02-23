package doranco.Entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "nombreDeChambres")
    private Integer nombreDeChambres;

    @OneToMany(mappedBy = "hotel")
    private Set<Chambre> chambres = new HashSet<>();

    @OneToOne(mappedBy = "hotel")
    private Service service;

    // Getters && setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Integer getNombreDeChambres() {
        return nombreDeChambres;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNombreDeChambres(Integer nombreDeChambres) {
        this.nombreDeChambres = nombreDeChambres;
    }
}