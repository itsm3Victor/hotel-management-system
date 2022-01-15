package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.RoomEntity;
import com.project.hotelmanagementsystem.Repository.CustomerRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Service
@Transactional
public class CustomerRoomServiceImpl implements CustomerRoomService {
    @Autowired
    private CustomerRoomRepository customerRoomRepository;

    @Autowired
    private ManageRoomsService manageRoomsService;

    @Scheduled(fixedRate = 3600000, initialDelay=180000)
    public void displayRooms(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ROOM NO");
        model.addColumn("ROOM TYPE");
        model.addColumn("BED TYPE");
        model.addColumn("PRICE");

        try {
            List<RoomEntity> roomEntityList = manageRoomsService.displayRooms();

            int currentIndex = 0;
            while(currentIndex < roomEntityList.size()){
                model.addRow(new Object[] {
                        roomEntityList.get(currentIndex).getRoomno(),
                        roomEntityList.get(currentIndex).getRoomType(),
                        roomEntityList.get(currentIndex).getBedtype(),
                        roomEntityList.get(currentIndex).getPrice()
                });
                currentIndex ++;
            }
            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(80);
            table.getColumnModel().getColumn(1).setPreferredWidth(140);
            table.getColumnModel().getColumn(2).setPreferredWidth(120);
            table.getColumnModel().getColumn(3).setPreferredWidth(90);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void calculateTotal(JTextField days, JTextField price, JTextField tot){
        int day=Integer.parseInt(days.getText());
        int pr= Integer.parseInt(price.getText());
        int total=day*pr;
        System.out.println(total);
        tot.setText(Integer.toString(total));
    }

    public void addToDatabase(JTextField name, JTextField addr, JTextField phone, JTextField roomtype, JTextField bedtype, JTextField tot, String status){
        try {
            addToDatabase(name.getText(), addr.getText(), phone.getText(), roomtype.getText(), bedtype.getText(), tot.getText(), "0");
            JOptionPane.showMessageDialog(null, "New Customer Added");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


    public void addToDatabase(String name, String addr, String phone, String roomtype, String bedtype, String tot, String status) {
        customerRoomRepository.addToDatabase(name, addr, phone, roomtype, bedtype, tot, status);
    }

    public void checkOut(JTextField name){
        try {
            checkOut(name.getText());
            JOptionPane.showMessageDialog(null, "Checked out Successfully");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void checkOut(String name) {
        customerRoomRepository.checkOut(name);
    }
}
