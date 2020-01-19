package exercise03_2;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "fk_department")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "fk_office")
    private Office office;


    public Employee(String name) {
        this.name = name;

    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee() {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
