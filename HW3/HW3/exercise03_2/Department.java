package exercise03_2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "department")
    List<Employee> employees=new ArrayList();

    public Department(String name) {
        this.name = name;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department() {
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.setDepartment(this);
    }

}
