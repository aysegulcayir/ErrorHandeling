package com.example.customer.controllers;

import com.example.customer.models.Customer;
import com.example.customer.models.WebOrder;
import com.example.customer.repositories.CustomerRepository;
import com.example.customer.repositories.WebOrderRepository;
import com.example.customer.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/customer/")
public class CustomerController {

    @Autowired
    private CustomerOrderService customerOrderService;


    @GetMapping()
    public Iterable<Customer> getAll(){
        return this.customerOrderService.findAll();
    }

    @PostMapping()
    public Customer save(@RequestBody Customer customer){
        return this.customerOrderService.saveNewCustomer(customer);

    }

    @PutMapping()
    public Customer update(@RequestBody Customer customer){
        return this.customerOrderService.save(customer);

   }


    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        this.customerOrderService.deleteById(id);
        return Boolean.TRUE;
    }


    }
