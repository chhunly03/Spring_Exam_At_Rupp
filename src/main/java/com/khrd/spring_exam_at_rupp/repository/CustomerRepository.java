package com.khrd.spring_exam_at_rupp.repository;

import com.khrd.spring_exam_at_rupp.model.entity.Customer;
import com.khrd.spring_exam_at_rupp.model.request.CustomerRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerRepository {
    @Select("SELECT * FROM customers")
    List<Customer> getAllCustomer();

    @Select("""
        SELECT * FROM customers WHERE customer_id = #{id}
    """)
    Customer getCutomerByID(Integer id);

    @Select("""
        INSERT INTO customers VALUES (DEFAULT,#{customer_last_name},#{customer_first_name},#{customer_phone}) RETURNING customer_id
    """)
    Integer createCutomer( CustomerRequest customerRequest);

    @Select("""
        UPDATE customers SET customer_last_name = #{r.customer_last_name}, customer_first_name = #{r.customer_first_name}, 
        customer_phone = #{r.customer_phone} WHERE customer_id = #{id} RETURNING customer_id
    """)
    Integer updateCutomer(Integer id,@Param("r") CustomerRequest customerRequest);
}
