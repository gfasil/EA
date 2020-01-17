import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String appdate;
    private Patient patient;
    private Doctor doctor;
    @Embedded
    private Payment payment;
}
