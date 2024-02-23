package doranco.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "prixParNuit")
    private Double prixParNuit; // double pour des prix à virgule

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    // Getters & setters
    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Double getPrixParNuit() {
        return prixParNuit;
    }

    public String getType() {
        return type;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPrixParNuit(Double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
