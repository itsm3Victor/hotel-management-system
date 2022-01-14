package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> displayCustomers();
    void addCustomer(String oper, Customer cust);
    void deleteCustomer(String oper,Customer cust);
}
