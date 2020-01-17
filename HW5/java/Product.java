import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private String name;
    private String description;

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
