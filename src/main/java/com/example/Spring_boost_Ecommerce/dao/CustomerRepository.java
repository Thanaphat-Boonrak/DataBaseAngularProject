package com.example.Spring_boost_Ecommerce.dao;

import com.example.Spring_boost_Ecommerce.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
