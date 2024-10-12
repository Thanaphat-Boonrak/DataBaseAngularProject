package com.example.Spring_boost_Ecommerce.dao;


import com.example.Spring_boost_Ecommerce.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface StateRepostitory extends JpaRepository<State,Integer> {

    List<State> findByCountryCode(@Param("code") String code);

}
