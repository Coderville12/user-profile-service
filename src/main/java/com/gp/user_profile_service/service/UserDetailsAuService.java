package com.gp.user_profile_service.service;

import com.gp.user_profile_service.entity.UsersDetailsAu;
import com.gp.user_profile_service.repo.UserDetailsAuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsAuService {


    @Autowired
    private UserDetailsAuRepo userDetailsAuRepo;



    public UsersDetailsAu getUserDetails(Long id){

        return userDetailsAuRepo.findById(id).orElse(null);
    }



    public String saveUser(UsersDetailsAu user){

        userDetailsAuRepo.save(user);
        return "User Details are Saved";
    }

}
