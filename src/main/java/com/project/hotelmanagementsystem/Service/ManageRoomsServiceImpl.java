package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.RoomEntity;
import com.project.hotelmanagementsystem.Repository.ManageRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Service
@Transactional
public class ManageRoomsServiceImpl implements ManageRoomsService {
    @Autowired
    ManageRoomsRepository manageRoomsRepository;

    public void displayRooms(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ROOM NO");
        model.addColumn("ROOM TYPE");
        model.addColumn("BED TYPE");
        model.addColumn("PRICE");

        try {
            List<RoomEntity> roomEntityList = displayRooms();
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

    public List<RoomEntity> displayRooms(){
        return manageRoomsRepository.displayRooms();

    }

    public void addRooms(JTextField r1, JTextField r2, JTextField r3){
        try {
            addRooms(r1.getText(), r2.getText(), r3.getText());
            JOptionPane.showMessageDialog(null, "New Room Added");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void addRooms(String r1, String r2, String r3) {
        manageRoomsRepository.addRooms(r1, r2, Integer.parseInt(r3));
    }

    public void updateRooms(JTable table, JTextField r1, JTextField r2, JTextField r3){
        try {
            int i =table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            String no= model.getValueAt(i, 0).toString();
            String r1upd = model.getValueAt(i, 1).toString();
            String r2upd = model.getValueAt(i, 2).toString();
            String r3upd = model.getValueAt(i, 3).toString();
            System.out.println(no);
            System.out.println("r1" + r1.getText());
            System.out.println("r2" + r2.getText());
            System.out.println("r3" + r3.getText());
            System.out.println("no" + no);
//            updateRooms(r1.getText(), r2.getText(), r3.getText(), no);
            updateRooms(r1upd, r2upd, r3upd, no);
            JOptionPane.showMessageDialog(null, " Room Updated ");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void updateRooms(String r1, String r2, String r3, String no) {
        manageRoomsRepository.updateRooms(r1, r2, Integer.parseInt(r3), no);
    }

    public void deleteRooms(JTable table){
        try {
            int i =table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            String no= model.getValueAt(i, 0).toString();
            System.out.println(no);
            deleteRooms(no);
            JOptionPane.showMessageDialog(null, " Room Deleted ");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void deleteRooms(String no) {
        manageRoomsRepository.deleteRooms(no);
    }
}
