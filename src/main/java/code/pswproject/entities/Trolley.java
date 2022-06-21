package code.pswproject.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "Trolley")
public class Trolley {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Basic
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "related_purchase")
    private Buying buying;

    public Trolley() {
    }

    public Trolley(int quantity, Product product, Buying buying) {
        this.quantity = quantity;
        this.product = product;
        this.buying = buying;
    }

    public Trolley(Integer id, int quantity, Product product, Buying buying) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.buying = buying;
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", buying=" + buying +
                '}';
    }
}

