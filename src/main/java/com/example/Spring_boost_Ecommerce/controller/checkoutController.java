package com.example.Spring_boost_Ecommerce.controller;


import com.example.Spring_boost_Ecommerce.Services.CheckoutService;
import com.example.Spring_boost_Ecommerce.dto.Purchase;
import com.example.Spring_boost_Ecommerce.dto.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class checkoutController {

    private final CheckoutService checkoutService;


    public checkoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        return checkoutService.placeOrder(purchase);
    }
}
