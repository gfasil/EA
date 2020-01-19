package exercise03_2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Students {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private int stid;
    @Transient
    private String firstname;
    @Transient
    private String lastname;

    @ManyToMany(mappedBy = "studentsList")
    List<Course> courseList=new ArrayList<>();

    public Students() {
    }

    public Students(int stid, String firstname, String lastname) {
        this.stid = stid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", stid=" + stid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +

                '}';
    }

    public void addCourse(Course course){
        courseList.add(course);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }




    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }



}
