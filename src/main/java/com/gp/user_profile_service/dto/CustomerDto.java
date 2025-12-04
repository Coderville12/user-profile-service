package com.gp.user_profile_service.dto;


import com.gp.user_profile_service.model.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class CustomerDto {


    private String name;
    private String email;
    private String mobile;
    private String status;
    private String password;
    private List<Order> orders;
}
