package com.gp.user_profile_service.service;

import com.gp.user_profile_service.entity.CustomerOrderStats;
import com.gp.user_profile_service.event.OrderCreatedEvent;
import com.gp.user_profile_service.repo.CustomerOrderStatsRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderEventsConsumer {

    private final CustomerOrderStatsRepository statsRepo;

    public OrderEventsConsumer(CustomerOrderStatsRepository statsRepo) {
        this.statsRepo = statsRepo;
    }

    @KafkaListener(topics = "order.created", groupId = "user-service-consumer-group")
    public void consume(OrderCreatedEvent event) {

        CustomerOrderStats stats =
                statsRepo.findById(event.getCustomerId())
                        .orElse(new CustomerOrderStats(event.getCustomerId(), 0L, null, null));

        stats.setTotalOrders(stats.getTotalOrders() + 1);
        stats.setLastOrderValue(event.getTotalPrice());
        stats.setLastOrderTime(LocalDateTime.now());

        statsRepo.save(stats);

        System.out.println("Updated order stats for customer=" + event.getCustomerId());
    }
}

