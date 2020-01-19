package exercise03_2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private int courseNumber;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Students> studentsList=new ArrayList<>();

    public Course(int courseNumber, String name, List<Students> studentList) {
        this.courseNumber = courseNumber;
        this.name = name;
        this.studentsList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseNumber=" + courseNumber +
                ", name='" + name + '\'' +

                '}';
    }
    public Course addStudent(Students students){
        studentsList.add(students);
        students.addCourse(this);
        return this;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Course() {
    }


}
