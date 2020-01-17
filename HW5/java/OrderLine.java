import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private int id;
    @ManyToOne
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderLine() {
    }


}
