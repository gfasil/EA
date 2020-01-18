import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AirPort {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private String name;
    private String city;
    private String country;
    private int airportcode;
    @OneToMany(mappedBy = "airPort")
    @JoinColumn
    private List<Flight> flightList=new ArrayList<>();
    public void addFlight(Flight flight){

        flightList.add(flight);
        flight.setPort(this);
    }

}
