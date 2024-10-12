package com.nuwana.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {
    private int id;
    private String orderID;
    private String fullname;
    private String grade;
    private String month;
    private String subject;
    private String email;
    private String fees;
}
