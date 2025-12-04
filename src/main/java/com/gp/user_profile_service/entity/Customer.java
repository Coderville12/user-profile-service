package com.gp.user_profile_service.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.user_profile_service.model.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String mobile;

    private String status;

    @JsonIgnore
    @ToString.Exclude
    private String password;

//    @OneToMany(mappedBy = "customer", fetch = LAZY)
//    private List<Order> orders;  // WRONG in microservices ― but needed for learning
    @Transient   // IMPORTANT — tells Hibernate to ignore this field
    private List<Order> orders;
    @Version
    private Long version;
}
