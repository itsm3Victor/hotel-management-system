package com.project.hotelmanagementsystem.Service;

import javax.swing.*;

public interface CustomerRoomService {

    void displayRooms(JTable jTable);
    void calculateTotal(JTextField days, JTextField price, JTextField tot);
    void addToDatabase(JTextField name, JTextField addr, JTextField phone, JTextField roomtype, JTextField bedtype, JTextField tot, String status);
//    void addToDatabase(String name, String addr, String phone, String roomtype, String bedtype, String tot, String status);
    void checkOut(JTextField name);
//    void checkOut(String name);
}
