package com.gp.user_profile_service.repo;

import com.gp.user_profile_service.entity.CustomerOrderStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderStatsRepository extends JpaRepository<CustomerOrderStats, Long> {
}
