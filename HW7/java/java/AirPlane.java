import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class AirPlane {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private String model;
    private int capacity;
    private int serialnr;
    @OneToMany(mappedBy = "airPlane")
    @JoinColumn
    private List<Flight> flightList=new ArrayList<>();
    public void addFlight(Flight flight){

        flightList.add(flight);
        flight.setAirPlane(this);
    }
}
