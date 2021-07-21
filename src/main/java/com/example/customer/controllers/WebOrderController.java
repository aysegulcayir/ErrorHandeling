package com.example.customer.controllers;

import com.example.customer.models.WebOrder;
import com.example.customer.repositories.WebOrderRepository;
import com.example.customer.services.WebOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/weborder/")
public class WebOrderController {

    @Autowired
    private WebOrderService webOrderService;

    @GetMapping()
    public Iterable<WebOrder> getAll(){
        return this.webOrderService.getAll();
    }

    @PostMapping
    public WebOrder save(@RequestBody WebOrder webOrder){
        return this.webOrderService.saveNewOrder(webOrder);
    }
}
