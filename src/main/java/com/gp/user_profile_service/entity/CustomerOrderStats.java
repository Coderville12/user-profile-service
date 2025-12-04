package com.gp.user_profile_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer_order_stats")
public class CustomerOrderStats {


    @Id
    private Long customerId;
    private Long totalOrders;
    private Double lastOrderValue;
    private LocalDateTime lastOrderTime;


}
