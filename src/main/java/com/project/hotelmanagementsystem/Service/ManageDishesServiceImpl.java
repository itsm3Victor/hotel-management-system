package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.RestaurantEntity;
import com.project.hotelmanagementsystem.Repository.ManageDishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Service
@Transactional
public class ManageDishesServiceImpl implements ManageDishesService {
    @Autowired
    private ManageDishesRepository manageDishesRepository;

    public void displayDishes(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DISH NO");
        model.addColumn("DISH NAME");
        model.addColumn("DISH TYPE");
        model.addColumn("PRICE");

        try {
            List<RestaurantEntity> restaurantEntityList = displayDishes();
            int currentIndex = 0;
            while (currentIndex < restaurantEntityList.size()) {
                model.addRow(new Object[]{
                        restaurantEntityList.get(currentIndex).getItemNo(),
                        restaurantEntityList.get(currentIndex).getItemName(),
                        restaurantEntityList.get(currentIndex).getType(),
                        restaurantEntityList.get(currentIndex).getPrice()
                });
                currentIndex++;
            }
            table.setModel(model);
            table.setAutoResizeMode(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(70);
            table.getColumnModel().getColumn(1).setPreferredWidth(167);
            table.getColumnModel().getColumn(2).setPreferredWidth(90);
            table.getColumnModel().getColumn(3).setPreferredWidth(90);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RestaurantEntity> displayDishes(){
        return manageDishesRepository.displayDishes();
    }

    public void addDishes(JTextField d1, JTextField d2, JTextField d3){
        try {
            addDishes(d1.getText(), d2.getText(), d3.getText());
            JOptionPane.showMessageDialog(null, "New Dish Added");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addDishes(String d1, String d2, String d3){
        manageDishesRepository.addDishes(d1,d2,d3);
    }

    public void updateDishes(JTable table){
        try {
            int i = table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String no = model.getValueAt(i, 0).toString();
            String d1Upd = model.getValueAt(i, 1).toString();
            String d2Upd = model.getValueAt(i, 2).toString();
            String d3Upd = model.getValueAt(i, 3).toString();
            System.out.println(no);

            System.out.println("d1"+d1Upd);
            System.out.println("d2"+d2Upd);
            System.out.println("d3"+d3Upd);
            System.out.println("no"+no);
            updateDishes(d1Upd, d3Upd, d2Upd, no);
            JOptionPane.showMessageDialog(null, " Dish Updated ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateDishes(String d1, String d2, String d3, String no) {
        manageDishesRepository.updateDishes(d1, d2, d3, no);
    }

    public void deleteDishes(JTable table){
        try {
            int i = table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            String no = model.getValueAt(i, 0).toString();
            System.out.println(no);
            deleteDishes(no);
            JOptionPane.showMessageDialog(null, " Dish Deleted ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDishes(String no) {
        manageDishesRepository.deleteDishes(no);
    }
}
