package com.example.pswproject.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private int id;

    @Basic
    @Column(name="name",nullable = false)
    private String name;

    @Basic
    @Column(name="lasr_name",nullable = false)
    private String lastName;

    @Basic
    @Column(name="date_of_birth",nullable = false)
    private Date date;



}
