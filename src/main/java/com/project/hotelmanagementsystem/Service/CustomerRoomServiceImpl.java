package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.Restaurant;
import com.project.hotelmanagementsystem.Repository.CustomerRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRoomServiceImpl implements CustomerRoomService{
    @Autowired
    private CustomerRoomRepository customerRoomRepository;

    public List<Restaurant> FillCombo1(){
        return customerRoomRepository.FillCombo1();
    }

    public List<Restaurant> FillCombo2(){
        return customerRoomRepository.FillCombo2();
    }

    public List<Restaurant> FillDishes(){
        return customerRoomRepository.FillDishes();
    }

    public List<Restaurant> FillDrinks(){
        return customerRoomRepository.FillDrinks();
    }

    public String calculateAmount(String meals){
        return customerRoomRepository.calculateAmount(meals);
    }

    public void addToDatabase(String name, String addr, String phone, String comboBox_Dish, String comboBox_Drink, String totalA, String status) {
        customerRoomRepository.addToDatabase(name, addr, phone, comboBox_Dish, comboBox_Drink, totalA, status);
    }

    public void checkOut(String name) {
        customerRoomRepository.checkOut(name);
    }
}
