package code.pswproject.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "User",schema = "orders")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private int id;

    @Basic
    @Column(name="name",nullable = true)
    private String name;

    @Basic
    @Column(name="lasr_name",nullable = true)
    private String lastName;

    @Basic
    @Column(name="date_of_birth",nullable = true)
    private Date date;

    @Basic
    @Column(name = "email", nullable = false)
    private String email;

}
