package code.pswproject.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product", schema = "orders")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "price", nullable = false)
    private String price;

    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;

}
