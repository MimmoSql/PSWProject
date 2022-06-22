package code.pswproject.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user",schema = "orders")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name",nullable = true)
    private String name;

    @Basic
    @Column(name = "lastName",nullable = true)
    private String lastName;

    @Basic
    @Column(name = "date",nullable = true)
    private Date date;

    @Basic
    @Column(name = "email",nullable = true)
    private String email;

    public User() {
    }

    public User(Integer id, String name, String lastName, Date date, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.email = email;
    }

    public User(String name, String lastName, Date date, String email) {
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                '}';
    }
}
