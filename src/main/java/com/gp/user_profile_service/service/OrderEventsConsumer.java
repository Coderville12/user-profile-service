package com.gp.user_profile_service.service;

import com.gp.user_profile_service.repo.CustomerOrderStatsRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderEventsConsumer {

    private final CustomerOrderStatsRepository statsRepo;

    public OrderEventsConsumer(CustomerOrderStatsRepository statsRepo) {
        this.statsRepo = statsRepo;
    }

//    @KafkaListener(topics = "order-created", concurrency = "1")
//    public void consume(OrderCreatedEvent event) {
//
//        System.out.println("UserService received event for customerId: PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP@@@@@@@@@@@@@@@@ " + event.getCustomerId());
//        CustomerOrderStats stats =
//                statsRepo.findById(event.getCustomerId())
//                        .orElse(new CustomerOrderStats(event.getCustomerId(), 0L, null, null));
//
//        stats.setTotalOrders(stats.getTotalOrders() + 1);
//        stats.setLastOrderValue(event.getTotalPrice());
//        stats.setLastOrderTime(LocalDateTime.now());
//
//        statsRepo.save(stats);
//
//        System.out.println("Updated order stats for customer=" + event.getCustomerId());
//    }
}

