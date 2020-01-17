import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="tbl_order")
public class Order {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    private int orderId;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany( cascade = {CascadeType.ALL})
    @JoinColumn(name="fk_order")
    List<OrderLine>  orderLines=new ArrayList();
    @ManyToOne
    @JoinColumn(name="fk_customer")
    private Customer owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public List<OrderLine> getOrderLines() {
        return Collections.unmodifiableList(orderLines);
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }



    public Order(int orderId, Date date, Customer owner, List<OrderLine> orderLines) {
        this.orderId = orderId;
        this.date = date;
        this.owner = owner;
        this.orderLines = orderLines;
    }



    public Order() {
    }

    public void setCustomer(Customer owner) {
        this.owner=owner;
    }
}
