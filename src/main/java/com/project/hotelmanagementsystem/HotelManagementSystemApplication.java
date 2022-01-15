package com.project.hotelmanagementsystem;

import com.project.hotelmanagementsystem.GUI.LoginPage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

//import javax.swing.JButton;
//import javax.swing.JFrame;


//@ComponentScan
//@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan({"com.project.hotelmanagementsystem.HotelManagementSystemApplication","com.project.hotelmanagementsystem.GUI.AddRooms","com.project.hotelmanagementsystem.GUI.AddDishes","com.project.hotelmanagementsystem.GUI.AdminForm","com.project.hotelmanagementsystem.GUI.CustomerDetails","com.project.hotelmanagementsystem.GUI.CustomerRestaurant","com.project.hotelmanagementsystem.GUI.CustomerRoom","com.project.hotelmanagementsystem.GUI.loginPage","com.project.hotelmanagementsystem.GUI.secondPage"})
//@ComponentScan(basePackages = "com.project.hotelmanagementsystem.GUI")
@SpringBootApplication
public class HotelManagementSystemApplication {
    //	public static ApplicationContext applicationContext;
//	@Autowired
//	AATesting testing;
    public static void main(String[] args) {


        ApplicationContext context = new SpringApplicationBuilder(HotelManagementSystemApplication.class)
                .headless(false).run(args);


//		ApplicationContext applicationContext =
//				SpringApplication.run(HotelManagementSystemApplication.class, args);
//		for (String name: applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}

//		EventQueue.invokeLater(() -> {
//			loginPage ex = context.getBean(loginPage.class);
//			ex.setVisible(true);
//		});
//		Hotel hotel = Hotel.getInstance();
//		loginPage window = context.getBean(loginPage.class);
//		window.frame.setVisible(true);
//		loginPage a = context.getBean(loginPage.class);
//		JFrame frame = new JFrame();

//		loginPage a = new loginPage();
//		a.setVisible(true);
//		a.setBounds(50, 50, 1015, 574);
//		a.frame.setVisible(true);
//		a.setVisible(true);
//		a.pack();
//		a.setLocationRelativeTo(null);
//		a.setBounds(50, 50, 1015, 574);
//		a.initialize();
    }
}



