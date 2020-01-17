import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private String name;
    @OneToMany(mappedBy = "owner", cascade = {CascadeType.ALL})
    @JoinColumn
    private List<Order> orders=new ArrayList();

    public Customer() {
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

    public List<Order> getOrder() {
        return Collections.unmodifiableList(orders);
    }

    public void setOrder(List<Order> order) {
        this.orders = order;
    }

    public Customer(String name, List<Order> order) {
        this.name = name;
        this.orders = order;
    }

    public void addOrder(Order order){
        orders.add(order);
        order.setCustomer(this);

    }
    public void removeOrder(Order order){
        orders.remove(order);
        order.setCustomer(null);

    }
}
