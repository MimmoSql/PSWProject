package code.pswproject.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product",schema = "orders")
public class Product {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "name",nullable = true)
    private String name;

    @Basic
    @Column(name = "price",nullable = true)
    private int price;

    @Basic
    @Column(name = "quantity",nullable = true)
    private int quantity;

    public Product() {
    }

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Integer id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
