package com.project.hotelmanagementsystem.Service;

public interface CustomerRestaurantService {

    void addToDatabase(String name, String addr, String phone, String roomtype, String bedtype, String tot, String status);
    void checkOut(String name);
}
