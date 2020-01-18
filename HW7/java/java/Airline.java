import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private String name;
    @OneToMany(mappedBy = "airLine")
    @JoinColumn
    private List<Flight> flightList=new ArrayList<>();
    public Airline() {
    }
    public void addFlight(Flight flight){

        flightList.add(flight);
        flight.setAirLine(this);
    }
}
