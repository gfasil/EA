import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appdate='" + appdate + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", payment=" + payment +
                '}';
    }

    private String appdate;
    @OneToOne(cascade = {CascadeType.ALL})
    private Patient patient;
    @OneToOne(cascade = {CascadeType.ALL})
    private Doctor doctor;
    @Embedded
    private Payment payment;

    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Appointment(String appdate, Patient patient, Doctor doctor, Payment payment) {
        this.appdate = appdate;
        this.patient = patient;
        this.doctor = doctor;
        this.payment = payment;
    }
}
