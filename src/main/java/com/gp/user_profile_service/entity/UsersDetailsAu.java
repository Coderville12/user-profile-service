package com.gp.user_profile_service.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "au_userdetails")
public class UsersDetailsAu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
}
