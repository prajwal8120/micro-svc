package com.example.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/addOrder")
    public String addOrder() {
        // Call payment service
        String paymentServiceUrl = "http://localhost:8081/payment";
        restTemplate.postForObject(paymentServiceUrl, null, Void.class);
        // Call shipment service
        String shipmentServiceUrl = "http://localhost:8082/shipment";
        restTemplate.postForObject(shipmentServiceUrl, null, Void.class);

        return "Order added successfully.";
    }
}
