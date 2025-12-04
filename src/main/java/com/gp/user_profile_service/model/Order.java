package com.gp.user_profile_service.model;

import com.gp.user_profile_service.entity.Customer;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Order {
    private Long id;

    private String product;

    private Integer quantity;

    private Double amount;

    private Long customerId;

    // This field will create circular JSON loops (on purpose for learning)
    private Customer customer;   // do NOT mark @JsonIgnore yet – we want to reproduce problems

}
