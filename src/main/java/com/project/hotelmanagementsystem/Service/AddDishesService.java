package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.Restaurant;

import java.util.List;

public interface AddDishesService {
    List<Restaurant> displayDishes();
    void addDishes(String d1, String d2, String d3);
    void updateDishes(String d1, String d2, String d3, String no);
    void deleteDishes(String no);
}
