package com.gp.user_profile_service.controllers;

import com.gp.user_profile_service.entity.CustomerOrderStats;
import com.gp.user_profile_service.repo.CustomerOrderStatsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class CustomerOrderStatsController {

    private final CustomerOrderStatsRepository statsRepository;


    public CustomerOrderStatsController(CustomerOrderStatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    @GetMapping("/customerId")
    public ResponseEntity<CustomerOrderStats> getStats(@PathVariable Long customerId) {
        return statsRepository.findById(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
