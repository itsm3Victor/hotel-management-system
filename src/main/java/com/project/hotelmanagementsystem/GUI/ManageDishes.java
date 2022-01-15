package com.project.hotelmanagementsystem.GUI;

import com.project.hotelmanagementsystem.Entity.RestaurantEntity;
import com.project.hotelmanagementsystem.Service.ManageDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

@Component
public class ManageDishes extends JFrame {
    @Autowired
    private ManageDishesService manageDishesService;
    @Autowired
    private ApplicationContext context;

    private JPanel contentPane;
    private JTextField d1;
    private JTextField d2;
    private JTextField d3;
    private JTable table;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AddDishes frame = new AddDishes();
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
    public ManageDishes() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {

                manageDishesService.displayDishes(table);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 972, 611);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDishName = new JLabel("DISH NAME");
        lblDishName.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblDishName.setBounds(33, 211, 155, 22);
        contentPane.add(lblDishName);

        JLabel lblD = new JLabel("DISH PRICE");
        lblD.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblD.setBounds(33, 284, 155, 27);
        contentPane.add(lblD);

        JLabel lblDishType = new JLabel("DISH TYPE");
        lblDishType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblDishType.setBounds(33, 353, 155, 27);
        contentPane.add(lblDishType);

        d1 = new JTextField();
        d1.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d1.setBounds(182, 207, 232, 30);
        contentPane.add(d1);
        d1.setColumns(10);

        d2 = new JTextField();
        d2.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d2.setBounds(182, 282, 232, 30);
        contentPane.add(d2);
        d2.setColumns(10);

        d3 = new JTextField();
        d3.setFont(new Font("High Tower Text", Font.BOLD, 20));
        d3.setBounds(182, 351, 232, 30);
        contentPane.add(d3);
        d3.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(456, 194, 418, 279);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnAddDish = new JButton("ADD DISH");
        btnAddDish.setIcon(new ImageIcon("src\\main\\resources\\images\\plus (1).png"));
        btnAddDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageDishesService.addDishes(d1, d2, d3);
                manageDishesService.displayDishes(table);

            }
        });
        btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnAddDish.setBounds(45, 486, 176, 53);
        contentPane.add(btnAddDish);

        JButton btnDeleteDish = new JButton("DELETE DISH");
        btnDeleteDish.setIcon(new ImageIcon("src\\main\\resources\\images\\iconfinder_f-cross_256_282471 (1).png"));
        btnDeleteDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageDishesService.deleteDishes(table);
                manageDishesService.displayDishes(table);
            }
        });
        btnDeleteDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnDeleteDish.setBounds(245, 486, 221, 53);
        contentPane.add(btnDeleteDish);

        JButton btnUpdateDish = new JButton("UPDATE DISH");
        btnUpdateDish.setIcon(new ImageIcon("src\\main\\resources\\images\\updated.png"));
        btnUpdateDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageDishesService.updateDishes(table);
                manageDishesService.displayDishes(table);
            }
        });
        btnUpdateDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnUpdateDish.setBounds(502, 486, 221, 53);
        contentPane.add(btnUpdateDish);

        JButton btnBack = new JButton("BACK");
        btnBack.setIcon(new ImageIcon("src\\main\\resources\\images\\back.png"));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminForm af = context.getBean(AdminForm.class);
                af.setVisible(true);
                af.pack();
                af.setLocationRelativeTo(null);

                af.setBounds(100, 100, 1080, 633);
                setVisible(false);

            }
        });
        btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
        btnBack.setBounds(765, 486, 143, 53);
        contentPane.add(btnBack);

        JLabel label = new JLabel("");
        label.setBounds(879, 100, 239, 163);
        contentPane.add(label);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\images\\34.jpg"));
        lblNewLabel.setBounds(0, 0, 300, 195);
        contentPane.add(lblNewLabel);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon("src\\main\\resources\\images\\i3.jpg"));
        label_1.setBounds(310, -1, 319, 195);
        contentPane.add(label_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\images\\cock.jpg"));
        lblNewLabel_1.setBounds(623, 0, 331, 195);
        contentPane.add(lblNewLabel_1);
    }
}
