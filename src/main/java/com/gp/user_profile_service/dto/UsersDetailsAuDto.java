package com.gp.user_profile_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class UsersDetailsAuDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Department cannot be blank")
    @Size(max = 100, message = "Department cannot exceed 100 characters")
    private String department;
}
