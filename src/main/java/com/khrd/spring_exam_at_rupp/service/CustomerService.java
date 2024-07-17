package com.khrd.spring_exam_at_rupp.service;

import com.khrd.spring_exam_at_rupp.model.entity.Customer;
import com.khrd.spring_exam_at_rupp.model.request.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getAllCutomer();

    Customer getCutomerByID(Integer id);

    Integer createCustomer(CustomerRequest customerRequest);

    Integer updateCustomer(Integer id, CustomerRequest customerRequest);
}
