package exercise03_2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private int roomnumber;
    private String building;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees=new ArrayList();

    public Office() {
    }

    public Office(int roomnumber, String building, List<Employee> employees) {
        this.roomnumber = roomnumber;
        this.building = building;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
