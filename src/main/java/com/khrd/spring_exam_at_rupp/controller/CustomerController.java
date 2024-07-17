package com.khrd.spring_exam_at_rupp.controller;

import com.khrd.spring_exam_at_rupp.model.entity.Customer;
import com.khrd.spring_exam_at_rupp.model.request.CustomerRequest;
import com.khrd.spring_exam_at_rupp.model.responce.CustomerResponce;
import com.khrd.spring_exam_at_rupp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/All")
    public ResponseEntity<CustomerResponce<List<Customer>>> getAllCustomer()
    {
        CustomerResponce<List<Customer>> responce = CustomerResponce.<List<Customer>>builder()
                .message("Get All Cutomer Successfully")
                .payload(customerService.getAllCutomer())
                .httpStatus(HttpStatus.OK)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return ResponseEntity.ok(responce);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponce<Customer>>getCutomerByID(@PathVariable Integer id){
        Customer storCustomer = customerService.getCutomerByID(id);
        if(storCustomer == null){
            CustomerResponce<Customer> responce = CustomerResponce.<Customer>builder()
                    .message("Get Cutomer by id not Successfully")
                    .payload(customerService.getCutomerByID(id))
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responce);
        }else {
            CustomerResponce<Customer> responce = CustomerResponce.<Customer>builder()
                    .message("Get Cutomer by id Successfully")
                    .payload(customerService.getCutomerByID(id))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responce);
        }
    }

    @PostMapping("")
    public ResponseEntity<CustomerResponce<Customer>>CreateCustomer(@RequestBody CustomerRequest customerRequest){
        Integer StoreInfo = customerService.createCustomer(customerRequest);
        if(StoreInfo != null){
            CustomerResponce<Customer>responce = CustomerResponce.<Customer>builder()
                    .message("Create Customer Successfully")
                    .payload(customerService.getCutomerByID(StoreInfo))
                    .httpStatus(HttpStatus.CREATED)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responce);
        }else {
            CustomerResponce<Customer>responce = CustomerResponce.<Customer>builder()
                    .message("Create customer not successfully")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responce);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponce<Customer>>updateCustomer(@PathVariable Integer id,@RequestBody CustomerRequest customerRequest){
        Integer StorInfoUp = customerService.updateCustomer(id,customerRequest);
        if(StorInfoUp != null ){
            CustomerResponce<Customer>responce=CustomerResponce.<Customer>builder()
                    .message("Update customer successfully")
                    .payload(customerService.getCutomerByID(id))
                    .httpStatus(HttpStatus.OK)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responce);
        }else {
            CustomerResponce<Customer>responce=CustomerResponce.<Customer>builder()
                    .message("Update customer not successfully")
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            return ResponseEntity.ok(responce);
        }
    }

}
