package com.gp.user_profile_service.controllers;


import com.gp.user_profile_service.dto.UsersDetailsAuDto;
import com.gp.user_profile_service.entity.UsersDetailsAu;
import com.gp.user_profile_service.service.UserDetailsAuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/au")
public class UserDetailsAuController {


    @Autowired
    private UserDetailsAuService userDetailsAuService;


    @GetMapping("/user/{id}")
    public ResponseEntity<UsersDetailsAuDto> getUserDetailsForAU(@PathVariable Long id) {
            UsersDetailsAuDto usersDetailsAuDto=convertToDto( userDetailsAuService.getUserDetails(id));
            return ResponseEntity.ok(usersDetailsAuDto);
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveAuUserDetails(@RequestBody UsersDetailsAuDto usersDetailsAuDto) {
        if(usersDetailsAuDto.getName() == null || usersDetailsAuDto.getDepartment() == null){
            return ResponseEntity.badRequest().body("Invalid User Details Data");
        }
//        UsersDetailsAu exitingUser = userDetailsAuService.getUserDetails(usersDetailsAuDto.getId());
//        if(exitingUser != null){
//            return ResponseEntity.badRequest().body("User with Name " + usersDetailsAuDto.getName() + " already exists.");
//        }
       UsersDetailsAu usersDetailsAu = convertToEntity(usersDetailsAuDto);
         userDetailsAuService.saveUser(usersDetailsAu);
        return ResponseEntity.ok("User Details are Saved");
    }




    private UsersDetailsAu convertToEntity(UsersDetailsAuDto dto) {
        return UsersDetailsAu.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .build();
    }

    private  UsersDetailsAuDto convertToDto(UsersDetailsAu entity) {
        return UsersDetailsAuDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .department(entity.getDepartment())
                .build();
    }

}
