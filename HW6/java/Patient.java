import javax.persistence.*;

@Entity
@SecondaryTable(name="Address")
public class Patient {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(table = "Address")
    private String street;
    @Column(table = "Address")
    private String zip;
    @Column(table = "Address")
    private String city;
}
