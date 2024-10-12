package com.example.Spring_boost_Ecommerce.Services;

import com.example.Spring_boost_Ecommerce.dto.Purchase;
import com.example.Spring_boost_Ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
