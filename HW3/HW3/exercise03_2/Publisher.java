package exercise03_2;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Publisher {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;


    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

    private String name;
}
