package com.project.hotelmanagementsystem.GUI;

import com.project.hotelmanagementsystem.Exception.MyException;
import com.project.hotelmanagementsystem.Service.CustomerRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Date;
import javax.swing.ImageIcon;

@Component
public class CustomerRestaurant extends JFrame{
    @Autowired
    private ApplicationContext context;

    @Autowired
    CustomerRestaurantService customerRestaurantService;

    private JPanel contentPane;
    private JTextField name;
    private JTextField addr;
    private JTextField phone;
    private JTextField meal;
    private JTextField drink;
    JComboBox comboBox_Dish = new JComboBox();
    JComboBox comboBox_Drink = new JComboBox();
    private JTable table;
    private JTable table_1;
    JTextArea area = new JTextArea();
    private JTextField totalA;
    JLabel a1 = new JLabel("*");
    JLabel a2 = new JLabel("*");
    JLabel a3 = new JLabel("*");
    SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
    Date dt= new Date();
    int flag=0;

//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    CustomerRoom frame = new CustomerRoom();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public CustomerRestaurant() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                customerRestaurantService.FillDishes(table);
                customerRestaurantService.FillDrinks(table_1);
                customerRestaurantService.FillCombo(comboBox_Dish, comboBox_Drink);

                a1.setVisible(false);
                a2.setVisible(false);
                a3.setVisible(false);
            }
        });

//        FillCombo();
        //FillDishes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1367, 772);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblArizonaTea = new JLabel("NAME");
        lblArizonaTea.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblArizonaTea.setBounds(34, 299, 104, 26);
        contentPane.add(lblArizonaTea);

        JLabel lblPinaColada = new JLabel("SELECT DRINK");
        lblPinaColada.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblPinaColada.setBounds(22, 199, 183, 26);
        contentPane.add(lblPinaColada);

        name = new JTextField();
        name.setFont(new Font("High Tower Text", Font.BOLD, 21));
        name.setBounds(213, 295, 255, 34);
        contentPane.add(name);
        name.setColumns(10);
        String Name = name.getText();


        JLabel lblNewLabel = new JLabel("ADDRESS");
        lblNewLabel.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblNewLabel.setBounds(34, 360, 165, 21);
        contentPane.add(lblNewLabel);

        JLabel lblEspresso = new JLabel("PHONE NUM");
        lblEspresso.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblEspresso.setBounds(34, 414, 165, 21);
        contentPane.add(lblEspresso);

        addr = new JTextField();
        addr.setFont(new Font("High Tower Text", Font.BOLD, 20));
        addr.setBounds(213, 353, 255, 34);
        contentPane.add(addr);
        addr.setColumns(10);

        phone = new JTextField();
        phone.setFont(new Font("High Tower Text", Font.BOLD, 20));
        phone.setBounds(213, 407, 255, 34);
        contentPane.add(phone);
        phone.setColumns(10);

        JLabel lblTotal = new JLabel("COST OF MEAL");
        lblTotal.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblTotal.setBounds(33, 501, 192, 34);
        contentPane.add(lblTotal);

        meal = new JTextField();
        meal.setFont(new Font("High Tower Text", Font.PLAIN, 20));
        meal.setBounds(233, 501, 140, 34);
        contentPane.add(meal);
        meal.setColumns(10);

        JLabel lblCostOfDrinks = new JLabel("COST OF DRINKS");
        lblCostOfDrinks.setFont(new Font("High Tower Text", Font.BOLD, 21));
        lblCostOfDrinks.setBounds(22, 561, 207, 26);
        contentPane.add(lblCostOfDrinks);

        drink = new JTextField();
        drink.setFont(new Font("High Tower Text", Font.PLAIN, 20));
        drink.setBounds(233, 557, 140, 34);
        contentPane.add(drink);
        drink.setColumns(10);

        JLabel lblSelectDish = new JLabel("SELECT DISH");
        lblSelectDish.setForeground(new Color(255, 255, 255));
        lblSelectDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblSelectDish.setBounds(34, 128, 181, 22);
        contentPane.add(lblSelectDish);

        //JComboBox comboBox_Dish = new JComboBox();
        comboBox_Dish.setFont(new Font("High Tower Text", Font.BOLD, 21));
        comboBox_Dish.setBounds(213, 122, 281, 34);
        contentPane.add(comboBox_Dish);

        //JComboBox comboBox_Drink = new JComboBox();
        comboBox_Drink.setFont(new Font("High Tower Text", Font.BOLD, 21));
        comboBox_Drink.setBounds(215, 195, 268, 34);
        contentPane.add(comboBox_Drink);

        JButton btnGenerateReceipt = new JButton("GENERATE RECEIPT");
        btnGenerateReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {




                if(name.getText().equals(""))
                {
                    a1.setVisible(true);
                }
                if(addr.getText().equals(""))
                {
                    a2.setVisible(true);
                }
                if(addr.getText().equals(""))
                {
                    a3.setVisible(true);
                }

                else {
                    sf.format(dt);
                    customerRestaurantService.calculateAmount(comboBox_Dish, comboBox_Drink, meal, drink, totalA);
                    area.setText("***********************************************\n");
                    area.setText(area.getText()+"***               YOUR BILL RECEIPT        	    ***\n");
                    area.setText(area.getText()+"***********************************************\n\n");
                    area.setText(area.getText()+"TIME     : "+sf.format(dt)+"\n\n");
                    area.setText(area.getText()+"NAME     :    "+name.getText()+"\n\n");
                    area.setText(area.getText()+"ADDRESS  :    "+addr.getText()+"\n\n");
                    area.setText(area.getText()+"PHONE NUM  :    "+phone.getText()+"\n\n");
                    area.setText(area.getText()+"ORDERED DISH  : "+comboBox_Dish.getSelectedItem()+"\n\n");
                    area.setText(area.getText()+"ORDERED DRINK  : "+comboBox_Drink.getSelectedItem()+"\n\n");
                    area.setText(area.getText()+"TOTAL AMOUNT   :   "+totalA.getText()+"\n\n");
                    ///////////////////////////area.setText(area.getText()+"COST OF MEAL : "+drink.getText()+"\n\n");

                    customerRestaurantService.addToDatabase(name, addr, phone, comboBox_Dish, comboBox_Drink, totalA, "0");
                    flag=1;
                }
            }
        });
        btnGenerateReceipt.setFont(new Font("High Tower Text", Font.BOLD, 21));
        btnGenerateReceipt.setBounds(257, 673, 281, 39);
        contentPane.add(btnGenerateReceipt);

        JButton btnTotal = new JButton("TOTAL");
        btnTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    if(name.getText().equals(""))
                    {   a1.setVisible(true);
                        throw new MyException("Exception : Please Fill all the details");

                    }
                    else if(addr.getText().equals(""))
                    {   a2.setVisible(true);
                        throw new MyException("Exception :Please Fill all the details");

                    }
                    else if(phone.getText().equals(""))
                    {   a3.setVisible(true);
                        throw new MyException("Exception :Please Fill all the details");

                    }

                    else
                    {
                        customerRestaurantService.calculateAmount(comboBox_Dish, comboBox_Drink, meal, drink, totalA);
                    }
                }

                catch(MyException r)
                {
                    JOptionPane.showMessageDialog(CustomerRestaurant.this, r);
                }
            }
        });
        btnTotal.setFont(new Font("High Tower Text", Font.BOLD, 21));
        btnTotal.setBounds(45, 673, 154, 39);
        contentPane.add(btnTotal);

        JButton btnCheckout = new JButton("CHECKOUT");
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customerRestaurantService.checkOut(name);

            }
        });
        btnCheckout.setFont(new Font("High Tower Text", Font.BOLD, 21));
        btnCheckout.setBounds(608, 673, 207, 39);
        contentPane.add(btnCheckout);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(522, 88, 350, 280);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(522, 388, 350, 259);
        contentPane.add(scrollPane_1);

        table_1 = new JTable();
        scrollPane_1.setViewportView(table_1);
        area.setFont(new Font("High Tower Text", Font.PLAIN, 18));


        area.setBounds(909, 190, 447, 470);
        contentPane.add(area);

        totalA = new JTextField();
        totalA.setFont(new Font("High Tower Text", Font.BOLD, 20));
        totalA.setBounds(231, 613, 142, 34);
        contentPane.add(totalA);
        totalA.setColumns(10);

        JLabel lblTotalAmount = new JLabel("TOTAL");
        lblTotalAmount.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblTotalAmount.setBounds(73, 618, 126, 25);
        contentPane.add(lblTotalAmount);

        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(flag==0)
                    JOptionPane.showMessageDialog(null, "First you need to generate receipt");
                else {
                    Dashboard sp = context.getBean(Dashboard.class);
//                    SecondPage sp = new SecondPage();
                    sp.setVisible(true);
                    sp.pack();
                    sp.setLocationRelativeTo(null);
                    sp.setBounds(100, 100, 1015, 574);
                    setVisible(false);
                }

            }
        });
        btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnBack.setBounds(871, 673, 148, 39);
        contentPane.add(btnBack);


        a1.setForeground(Color.RED);
        a1.setFont(new Font("Tahoma", Font.BOLD, 21));
        a1.setBounds(473, 304, 21, 21);
        contentPane.add(a1);


        a2.setFont(new Font("Tahoma", Font.BOLD, 20));
        a2.setForeground(Color.RED);
        a2.setBounds(473, 366, 21, 21);
        contentPane.add(a2);


        a3.setForeground(Color.RED);
        a3.setFont(new Font("Tahoma", Font.BOLD, 20));
        a3.setBounds(473, 419, 21, 16);
        contentPane.add(a3);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("src\\main\\resources\\images\\41.jpg"));
        label.setBounds(0, 0, 1385, 187);
        contentPane.add(label);
    }

}
