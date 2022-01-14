package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.Restaurant;

import java.util.List;

public interface CustomerRoomService {
    List<Restaurant> FillCombo1();
    List<Restaurant> FillCombo2();
    List<Restaurant> FillDishes();
    List<Restaurant> FillDrinks();
    String calculateAmount(String meals);
    void addToDatabase(String name, String addr, String phone, String comboBox_Dish, String comboBox_Drink, String totalA, String status);
    void checkOut(String name);
}
