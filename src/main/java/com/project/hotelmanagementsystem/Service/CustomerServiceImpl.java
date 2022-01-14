package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.Customer;
import com.project.hotelmanagementsystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> displayCustomers(){
        return customerRepository.displayCustomers();
    }

    public void addCustomer(String oper, Customer cust) {
        try{
            if(oper=="d"){
                customerRepository.addCustomer(cust.getCustName(), cust.getAddr(), cust.getPhone(), cust.getPhone());
                JOptionPane.showMessageDialog(null,"New Customer Added");
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void deleteCustomer(String oper, Customer cust) {
        try {
            if(oper=="i")
            {
                customerRepository.deleteCustomer(cust.getCustName());
                JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
