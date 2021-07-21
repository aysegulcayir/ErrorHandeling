package com.example.customer.repositories;

import com.example.customer.models.WebOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebOrderRepository extends CrudRepository<WebOrder, Integer> {
    //Integer is Id class
}
