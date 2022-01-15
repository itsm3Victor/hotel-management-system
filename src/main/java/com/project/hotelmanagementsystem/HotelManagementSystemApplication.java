package com.project.hotelmanagementsystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class HotelManagementSystemApplication {
    public static void main(String[] args) {


        ApplicationContext context = new SpringApplicationBuilder(HotelManagementSystemApplication.class)
                .headless(false).run(args);

    }
}



