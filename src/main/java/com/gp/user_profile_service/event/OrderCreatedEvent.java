package com.gp.user_profile_service.event;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderCreatedEvent {

    private Long orderId;
    private Long customerId;
    private java.util.List<String> items;
    private double totalPrice;
}
