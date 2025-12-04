package com.gp.user_profile_service.consumer;

import com.gp.user_profile_service.event.OrderCreatedEvent;
import com.gp.user_profile_service.service.CustomerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventsConsumer {

    private final CustomerService customerService;

    public OrderEventsConsumer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @KafkaListener(
            topics = "order.created",
            groupId = "user-service-consumer-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(OrderCreatedEvent event) {

        System.out.println("UserService received event for customerId: " + event.getCustomerId());

        // Call service layer to update customer/order summary
        customerService.handleOrderCreated(event);
    }
}

