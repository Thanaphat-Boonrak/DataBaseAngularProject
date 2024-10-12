package com.example.Spring_boost_Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "country")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "country")
    private List<State> states;
}
