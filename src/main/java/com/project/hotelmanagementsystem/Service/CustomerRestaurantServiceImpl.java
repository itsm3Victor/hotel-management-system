package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Repository.CustomerRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerRestaurantServiceImpl implements CustomerRestaurantService{
    @Autowired
    private CustomerRestaurantRepository customerRestaurantRepository;

    public void addToDatabase(String name, String addr, String phone, String roomtype, String bedtype, String tot, String status) {
        customerRestaurantRepository.addToDatabase(name, addr, phone, roomtype, bedtype, tot, status);
    }

    public void checkOut(String name) {
        customerRestaurantRepository.checkOut(name);
    }
}
