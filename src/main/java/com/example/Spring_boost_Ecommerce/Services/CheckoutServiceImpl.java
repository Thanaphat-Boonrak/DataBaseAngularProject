package com.example.Spring_boost_Ecommerce.Services;

import com.example.Spring_boost_Ecommerce.Entity.Customer;
import com.example.Spring_boost_Ecommerce.Entity.Order;
import com.example.Spring_boost_Ecommerce.Entity.OrderItem;
import com.example.Spring_boost_Ecommerce.dao.CustomerRepository;
import com.example.Spring_boost_Ecommerce.dto.Purchase;
import com.example.Spring_boost_Ecommerce.dto.PurchaseResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
            this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(order::add);

        order.setBillingaddress(purchase.getBillingAddress());
        order.setShippingaddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
