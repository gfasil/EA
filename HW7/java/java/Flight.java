import javax.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    @ManyToOne
    private Airline airline;
    @ManyToOne
    private AirPlane airPlane;
    @ManyToOne
    private AirPort origin;
    @ManyToOne
    private AirPort destination;

    public void setAirLine(Airline airline) {
    this.airline=airline;
    }

    public void setAirPlane(AirPlane airPlane) {
   this.airPlane=airPlane;
    }

    public void setPort(AirPort airPort) {
   this.airPort=airPort;
    }
}
