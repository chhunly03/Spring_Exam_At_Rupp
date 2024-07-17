package com.khrd.spring_exam_at_rupp.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRequest {
    private String customer_last_name;
    private String customer_first_name;
    private String customer_phone;
}
