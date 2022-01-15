package com.project.hotelmanagementsystem.GUI;

import com.project.hotelmanagementsystem.Service.ManageRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

@Component
public class ManageRooms extends JFrame {
    @Autowired
    private ManageRoomsService manageRoomsService;
    @Autowired
    private ApplicationContext context;

    private JPanel contentPane;
    private JTable table;
    private JTextField r1;
    private JTextField r2;
    private JTextField r3;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    AddRooms frame = new AddRooms();
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
    public ManageRooms() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                manageRoomsService.displayRooms(table);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 965, 577);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAddRooms = new JButton("ADD ROOMS");
        btnAddRooms.setIcon(new ImageIcon("src\\main\\resources\\images\\plus (1).png"));
        btnAddRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageRoomsService.addRooms(r1, r2, r3);
                manageRoomsService.displayRooms(table);
            }
        });
        btnAddRooms.setFont(new Font("High Tower Text", Font.BOLD, 23));
        btnAddRooms.setBounds(12, 456, 225, 50);
        contentPane.add(btnAddRooms);

        JButton btnAddDish = new JButton("UPDATE ROOMS");
        btnAddDish.setIcon(new ImageIcon("src\\main\\resources\\images\\updated.png"));
        btnAddDish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageRoomsService.updateRooms(table, r1, r2, r3);
                manageRoomsService.displayRooms(table);
            }
        });
        btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 23));
        btnAddDish.setBounds(518, 456, 270, 50);
        contentPane.add(btnAddDish);

        JButton btnDleteRooms = new JButton("DELETE ROOMS");
        btnDleteRooms.setIcon(new ImageIcon("src\\main\\resources\\images\\iconfinder_f-cross_256_282471 (1).png"));
        btnDleteRooms.setFont(new Font("High Tower Text", Font.BOLD, 23));
        btnDleteRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manageRoomsService.deleteRooms(table);
                manageRoomsService.displayRooms(table);
            }
        });
        btnDleteRooms.setBounds(248, 457, 258, 49);
        contentPane.add(btnDleteRooms);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(330, 201, 431, 242);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblRoomType = new JLabel("ROOM TYPE");
        lblRoomType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblRoomType.setBounds(12, 216, 136, 38);
        contentPane.add(lblRoomType);

        JLabel lblBedType = new JLabel("BED TYPE");
        lblBedType.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblBedType.setBounds(12, 289, 136, 25);
        contentPane.add(lblBedType);

        JLabel lblPrice = new JLabel("PRICE");
        lblPrice.setFont(new Font("High Tower Text", Font.BOLD, 20));
        lblPrice.setBounds(23, 345, 107, 27);
        contentPane.add(lblPrice);

        r1 = new JTextField();
        r1.setFont(new Font("High Tower Text", Font.BOLD, 20));
        r1.setBounds(160, 220, 147, 30);
        contentPane.add(r1);
        r1.setColumns(10);

        r2 = new JTextField();
        r2.setFont(new Font("High Tower Text", Font.BOLD, 20));
        r2.setBounds(160, 286, 146, 30);
        contentPane.add(r2);
        r2.setColumns(10);

        r3 = new JTextField();
        r3.setFont(new Font("High Tower Text", Font.BOLD, 20));
        r3.setBounds(160, 343, 147, 30);
        contentPane.add(r3);
        r3.setColumns(10);

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
        btnBack.setBounds(800, 457, 136, 50);
        contentPane.add(btnBack);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\images\\collage.jpg"));
        lblNewLabel.setBounds(0, 0, 947, 202);
        contentPane.add(lblNewLabel);
    }
}
