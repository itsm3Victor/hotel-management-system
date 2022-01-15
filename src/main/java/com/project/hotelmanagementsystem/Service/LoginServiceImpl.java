package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginRepository;

    public String loginVerificationService(String username, String password){
        System.out.println("username"+ username + "password"+ password);
        return loginRepository.loginVerification(username, password);
    }
}
