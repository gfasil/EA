package exercise03_2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private String name;
    @OneToMany
    @JoinColumn
    private List<Reservation> reservations=new ArrayList();

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservation() {
        return reservations;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservations = reservation;
    }

    public Customer(String name, List<Reservation> reservation) {
        this.name = name;
        this.reservations = reservation;
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);

    }
}
