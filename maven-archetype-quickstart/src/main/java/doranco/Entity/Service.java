package doranco.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "piscine")
    private Boolean piscine;

    @Column(name = "spa")
    private Boolean spa;

    @Column(name = "restaurant")
    private Boolean restaurant;

    @Column(name = "boisson")
    private Boolean boisson;

    @OneToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    // Getters & setters
    public Long getId() {
        return id;
    }

    public Boolean getPiscine() {
        return piscine;
    }

    public Boolean getSpa() {
        return spa;
    }

    public Boolean getRestaurant() {
        return restaurant;
    }

    public Boolean getBoisson() {
        return boisson;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPiscine(Boolean piscine) {
        this.piscine = piscine;
    }

    public void setSpa(Boolean spa) {
        this.spa = spa;
    }

    public void setRestaurant(Boolean restaurant) {
        this.restaurant = restaurant;
    }

    public void setBoisson(Boolean boisson) {
        this.boisson = boisson;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
