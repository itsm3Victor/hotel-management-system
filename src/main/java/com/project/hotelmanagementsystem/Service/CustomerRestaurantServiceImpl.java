package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.RestaurantEntity;
import com.project.hotelmanagementsystem.Repository.CustomerRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

@Service
@Transactional
public class CustomerRestaurantServiceImpl implements CustomerRestaurantService {
    @Autowired
    private CustomerRestaurantRepository customerRestaurantRepository;


    public void FillCombo(JComboBox comboBox_Dish, JComboBox comboBox_Drink){
//        List<JComboBox> jComboBoxList = new ArrayList<>();
        try {
            List<RestaurantEntity> fillComboList1 = FillCombo1();

            int currentIndex1 = 0;
            while(currentIndex1 < fillComboList1.size()) {
                comboBox_Dish.addItem(fillComboList1.get(currentIndex1).getItemName());
                currentIndex1++;
            }

            List<RestaurantEntity> fillComboList2 = FillCombo2();

            int currentIndex2 = 0;
            while (currentIndex2 < fillComboList2.size()){
                comboBox_Drink.addItem(fillComboList2.get(currentIndex2).getItemName());
                currentIndex2 ++;
            }

//            jComboBoxList.add(comboBox_Dish);
//            jComboBoxList.add(comboBox_Drink);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//        return jComboBoxList;
    }

    public List<RestaurantEntity> FillCombo1(){
        return customerRestaurantRepository.FillCombo1();
    }

    public List<RestaurantEntity> FillCombo2(){
        return customerRestaurantRepository.FillCombo2();
    }

    public void FillDishes(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DISH NAME");
        model.addColumn("PRICE");

        try {
            List<RestaurantEntity> dishList = FillDishes();
            int currentIndex = 0;
            while (currentIndex < dishList.size()) {
                model.addRow(new Object[]{
                        dishList.get(currentIndex).getItemName(),
                        dishList.get(currentIndex).getPrice(),
                });
                System.out.println("dishName" + dishList.get(currentIndex).getItemName() + "  " + "Price" + dishList.get(currentIndex).getPrice());
                currentIndex++;
                table.setModel(model);
                table.setAutoResizeMode(0);
                table.getColumnModel().getColumn(0).setPreferredWidth(250);
                table.getColumnModel().getColumn(1).setPreferredWidth(100);

            }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<RestaurantEntity> FillDishes(){
        return customerRestaurantRepository.FillDishes();
    }

    public void FillDrinks(JTable table_1){
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("DRINK NAME");
        model2.addColumn("PRICE");

        try {
            List<RestaurantEntity> drinkList = FillDrinks();
            int currentIndex = 0;
            while(currentIndex < drinkList.size()){
                model2.addRow(new Object[] {
                        drinkList.get(currentIndex).getItemName(),
                        drinkList.get(currentIndex).getPrice(),
                });
                currentIndex ++;
            }
            table_1.setModel(model2);
            table_1.setAutoResizeMode(0);
            table_1.getColumnModel().getColumn(0).setPreferredWidth(250);
            table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<RestaurantEntity> FillDrinks(){
        return customerRestaurantRepository.FillDrinks();
    }

    public void calculateAmount(JComboBox comboBox_Dish, JComboBox comboBox_Drink, JTextField meal, JTextField drink, JTextField totalA){
        String di=(String)comboBox_Dish.getSelectedItem();
        String dr=(String)comboBox_Drink.getSelectedItem();
        try {
            String mealAmount = calculateAmount(di);
            meal.setText(mealAmount);

            String drinkAmount = calculateAmount(dr);
            drink.setText(drinkAmount);
            int total=Integer.parseInt(mealAmount)+Integer.parseInt(drinkAmount);
            totalA.setText(Integer.toString(total));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String calculateAmount(String meals){
        return customerRestaurantRepository.calculateAmount(meals);
    }

    public void addToDatabase(JTextField name, JTextField addr, JTextField phone, JComboBox comboBox_Dish, JComboBox comboBox_Drink, JTextField totalA, String status){
        try {
            addToDatabase(name.getText(), addr.getText(), phone.getText(), comboBox_Dish.getSelectedItem().toString(), comboBox_Drink.getSelectedItem().toString(), totalA.getText(), "0");
            JOptionPane.showMessageDialog(null, "New Customer Added");
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void addToDatabase(String name, String addr, String phone, String comboBox_Dish, String comboBox_Drink, String totalA, String status) {
        customerRestaurantRepository.addToDatabase(name, addr, phone, comboBox_Dish, comboBox_Drink, totalA, status);
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
        customerRestaurantRepository.checkOut(name);
    }
}
