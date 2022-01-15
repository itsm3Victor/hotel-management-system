package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.room;
import com.project.hotelmanagementsystem.Repository.AddRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddRoomsServiceImpl implements AddRoomsService{
    @Autowired
    AddRoomsRepository addRoomsRepository;

    public List<room> displayRooms(){
        return addRoomsRepository.displayRooms();

    }

    public void addRooms(String r1, String r2, String r3) {
        addRoomsRepository.addRooms(r1, r2, r3);
    }

    public void updateRooms(String r1, String r2, String r3, String no) {
        addRoomsRepository.updateRooms(r1, r2, r3, no);
    }

    public void deleteRooms(String no) {
        addRoomsRepository.deleteRooms(no);
    }
}
