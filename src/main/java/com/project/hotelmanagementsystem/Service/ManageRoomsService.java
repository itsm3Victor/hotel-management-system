package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.RoomEntity;

import javax.swing.*;
import java.util.List;


public interface ManageRoomsService {
    void displayRooms(JTable table);
    List<RoomEntity> displayRooms();
    void addRooms(JTextField r1, JTextField r2, JTextField r3);
//    void addRooms(String r1, String r2, String r3);
    void updateRooms(JTable table, JTextField r1, JTextField r2, JTextField r3);
//    void updateRooms(String r1, String r2, String r3, String no);
    void deleteRooms(JTable table);
//    void deleteRooms(String no);
}
