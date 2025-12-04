package com.gp.user_profile_service.repo;

import com.gp.user_profile_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    public Customer findByEmail(String email);
}
