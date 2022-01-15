package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.RestaurantEntity;

import javax.swing.*;
import java.util.List;

public interface ManageDishesService {
    void displayDishes(JTable table);
    List<RestaurantEntity> displayDishes();
    void addDishes(JTextField d1, JTextField d2, JTextField d3);
//    void addDishes(String d1, String d2, String d3);
    void updateDishes(JTable table);
//    void updateDishes(String d1, String d2, String d3, String no);
    void deleteDishes(JTable table);
//    void deleteDishes(String no);
}
