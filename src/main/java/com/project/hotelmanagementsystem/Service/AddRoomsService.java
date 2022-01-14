package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.room;

import java.util.List;


public interface AddRoomsService {
    List<room> displayRooms();
    void addRooms(String r1, String r2, String r3);
    void updateRooms(String r1, String r2, String r3, String no);
    void deleteRooms(String no);
}
