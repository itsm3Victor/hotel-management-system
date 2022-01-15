package com.project.hotelmanagementsystem.Service;

import javax.swing.*;

public interface CustomerRestaurantService {
    void FillCombo(JComboBox comboBox_Dish, JComboBox comboBox_Drink);
//    List<Restaurant> FillCombo1();
//    List<Restaurant> FillCombo2();
    void FillDishes(JTable table);
//    List<Restaurant> FillDishes();
    void FillDrinks(JTable table_1);
//    List<Restaurant> FillDrinks();
    void calculateAmount(JComboBox comboBox_Dish, JComboBox comboBox_Drink, JTextField meal, JTextField drink, JTextField totalA);
//    String calculateAmount(String meals);
    void addToDatabase(JTextField name, JTextField addr, JTextField phone, JComboBox comboBox_Dish, JComboBox comboBox_Drink, JTextField totalA, String status);
//    void addToDatabase(String name, String addr, String phone, String comboBox_Dish, String comboBox_Drink, String totalA, String status);
    void checkOut(JTextField name);
//    void checkOut(String name);
}
