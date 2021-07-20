package com.example.customer.services;

import com.example.customer.models.Customer;
import com.example.customer.models.WebOrder;
import com.example.customer.repositories.CustomerRepository;
import com.example.customer.repositories.WebOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WebOrderService {

    @Autowired
    private WebOrderRepository webOrderRepository;


    @Autowired
    private CustomerRepository customerRepository;

    public WebOrder saveNewOrder(WebOrder newWebOrder) {

        //Check if the customer exists in the database
        Customer customerOfOrder = newWebOrder.getCustomer();
        if (customerOfOrder!=null){

            if (this.customerRepository.existsById(customerOfOrder.getId())) {
                // Save weborder
                return this.webOrderRepository.save(newWebOrder);

            }
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );

        }

        //If the customer does not exist, throw error / return 404
        return null;
    }
    public Iterable<WebOrder> getAll(){

        return this.webOrderRepository.findAll();
    }

}
