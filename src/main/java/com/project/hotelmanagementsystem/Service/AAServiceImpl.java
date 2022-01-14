package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Repository.AARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AAServiceImpl implements  AAService{
    @Autowired
    AARepository aaRepository;

    public String loginVerificationService(String username, String password){
        System.out.println("username"+ username + "password"+ password);
        return aaRepository.loginVerification(username, password);
    }
}
