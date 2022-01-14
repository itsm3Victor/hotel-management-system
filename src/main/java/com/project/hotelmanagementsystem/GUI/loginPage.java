package com.project.hotelmanagementsystem.GUI;

import com.project.hotelmanagementsystem.Entity.Hotel;
import com.project.hotelmanagementsystem.Entity.room;
import com.project.hotelmanagementsystem.HotelManagementSystemApplication;
import com.project.hotelmanagementsystem.Service.AAService;
import com.project.hotelmanagementsystem.Service.AddRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;

@Component
public class loginPage extends JFrame {
//    @Autowired
//    private Hotel hotel;

    @Autowired
    private AAService aaService;

    @Autowired
    private AddRoomsService addRoomsService;

    private JFrame frame;
    private JTextField tfusername;
    private JPasswordField tfpwd;
    JLabel Ustar = new JLabel("*");
    JLabel Pstar = new JLabel("*");

    /**
     * Launch the application.
     */
    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            Hotel hotel = Hotel.getInstance();

            public void run() {
                try {

                    loginPage window = new loginPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginPage() {
//        main();
//        Hotel hotel = Hotel.getInstance();
//        frame.setVisible(true);
        initialize();
        Ustar.setVisible(false);
        Pstar.setVisible(false);

    }

    public void initialize() {
//        Hotel hotel = Hotel.getInstance();
//        loginPage window = new loginPage();
//        window.frame.setVisible(true);
//        loginPage window = new loginPage();
        frame = new JFrame();
//        frame.setVisible(true);
        frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 23));
        frame.setBounds(50, 50, 898, 624);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("LOGIN ");
        lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblLogin.setBounds(369, 190, 212, 67);
        frame.getContentPane().add(lblLogin);

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblUsername.setBounds(269, 324, 155, 50);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 23));
        lblPassword.setBounds(280, 413, 133, 38);
        frame.getContentPane().add(lblPassword);

        tfusername = new JTextField();
        tfusername.setFont(new Font("Times New Roman", Font.BOLD, 23));
        tfusername.setBounds(489, 331, 208, 38);
        frame.getContentPane().add(tfusername);
        tfusername.setColumns(10);

        tfpwd = new JPasswordField();
        tfpwd.setFont(new Font("Times New Roman", Font.BOLD, 23));
        tfpwd.setBounds(489, 414, 208, 38);
        frame.getContentPane().add(tfpwd);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Ustar.setVisible(false);
                Pstar.setVisible(false);
                if (tfusername.getText().equals("")) {
                    Ustar.setVisible(true);
                }
                if (String.valueOf(tfpwd.getPassword()).equals("")) {
                    Pstar.setVisible(true);
                } else {
                    // String url,user,pwd;

//                    GetConnection connect = new GetConnection();
//                    Connection conn = connect.getConnection();
                    try {
                        // Connection connect =DriverManager.getConnection(url, user, pwd);
                        // System.out.println("Connection success");
                        String rs = aaService.loginVerificationService(tfusername.getText(), String.valueOf(tfpwd.getPassword()));
                        List<room> roomList = addRoomsService.displayRooms();
                        for(int i = 0; i < roomList.size(); i ++){
                            System.out.print(roomList.get(i).Price);
                            System.out.print(roomList.get(i).roomno);
                            System.out.print(roomList.get(i).bedtype);
                            System.out.print(roomList.get(i).roomType);
                            System.out.print(roomList.get(i).status);
                            System.out.println();
                        }

//                        PreparedStatement ps = conn
//                                .prepareStatement("SELECT * FROM login WHERE username= ? AND password=? ");
//                        ps.setString(1, tfusername.getText());
//                        ps.setString(2, String.valueOf(tfpwd.getPassword()));
//
//                        ResultSet rs = ps.executeQuery();
                        if (rs != null) {
                            secondPage sp = new secondPage();

                            sp.setVisible(true);
                            sp.pack();
                            sp.setLocationRelativeTo(null);
                            sp.setBounds(50, 50, 1015, 574);
                            frame.setVisible(false);

                        } else
                            JOptionPane.showMessageDialog(null, "Error", "Please check user name / password",
                                    JOptionPane.ERROR_MESSAGE);

//                    } catch (SQLException p) {
                    } catch (Exception p){
                        p.printStackTrace();
                    }
                }
            }
        });
        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnLogin.setBounds(288, 513, 147, 50);
        frame.getContentPane().add(btnLogin);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnCancel.setBounds(565, 513, 155, 51);
        frame.getContentPane().add(btnCancel);

        Ustar.setForeground(Color.RED);
        Ustar.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Ustar.setBounds(699, 347, 46, 21);
        frame.getContentPane().add(Ustar);

        Pstar.setForeground(Color.RED);
        Pstar.setFont(new Font("Times New Roman", Font.BOLD, 28));
        Pstar.setBounds(699, 430, 46, 21);
        frame.getContentPane().add(Pstar);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\hotel-management-system\\src\\main\\resources\\images\\login (8).png"));
        label.setBounds(12, 234, 314, 283);
        frame.getContentPane().add(label);

        JLabel lblHotelManagementSystem = new JLabel("HOTEL MANAGEMENT SYSTEM");
        lblHotelManagementSystem.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
        lblHotelManagementSystem.setBounds(109, 72, 636, 80);
        frame.getContentPane().add(lblHotelManagementSystem);

        frame.setVisible(true);
    }

}
