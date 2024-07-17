package com.khrd.spring_exam_at_rupp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
    private Integer customer_id;
    private String customer_last_name;
    private String customer_first_name;
    private String customer_phone;
}
