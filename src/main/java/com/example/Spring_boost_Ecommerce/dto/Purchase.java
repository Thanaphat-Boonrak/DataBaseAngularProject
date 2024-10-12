package com.example.Spring_boost_Ecommerce.dto;

import com.example.Spring_boost_Ecommerce.Entity.Address;
import com.example.Spring_boost_Ecommerce.Entity.Customer;
import com.example.Spring_boost_Ecommerce.Entity.Order;
import com.example.Spring_boost_Ecommerce.Entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
