package com.example.Spring_boost_Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
@Setter
@Getter
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "first_name")
    private String first_name;


    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

    public void add(Order item){
        if(item != null){
            if(orders == null){
                orders = new HashSet<>();
            }
            orders.add(item);
            item.setCustomer(this);
        }
    }
}
