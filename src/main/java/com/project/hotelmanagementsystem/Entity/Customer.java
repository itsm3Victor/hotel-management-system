package com.project.hotelmanagementsystem.Entity;

import com.project.hotelmanagementsystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String custName;

    @Column(name="address")
    private String addr;

    @Column(name="phone")
    private String phone;

    @Column(name="type")
    private String Type;

    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Customer()
    {

    }


    public Customer(int customerID, String custName, String addr, String phone, String Type) {
        this.id = customerID;
        this.custName = custName;
        this.addr = addr;
        this.phone = phone;
        this.Type = Type;
    }

    public void printCustomer()
    {
        System.out.println("Customer Name : "+this.custName);
        System.out.println("Customer Address : "+this.addr);
        System.out.println("Customer Phone : "+this.phone);
    }


//    public void addCustomer(String oper,Customer cust)
//    {   PreparedStatement ps = null;
//        ResultSet result = null;
//        try {
//            if(oper=="i")
//            {
//                GetConnection connect=new GetConnection();
//                Connection conn=connect.getConnection();
//                ps=conn.prepareStatement("INSERT INTO customer (customerName, address, phoneNo, type) VALUES (?,?,?,?)");
//                ps.setString(1,cust.custName);
//                ps.setString(2,cust.addr);
//                ps.setString(3,cust.phone);
//                ps.setString(4,cust.Type);
//
//
//                if(ps.executeUpdate()>0)
//                {
//                    JOptionPane.showMessageDialog(null, "New Customer Added");
//                }
//            }
//        }
//
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }
//
//
//    public void deleteCustomer(String oper,Customer cust)
//    {
//        PreparedStatement ps = null;
//        ResultSet result = null;
//        try {
//            if(oper=="d")
//            {
//                GetConnection connect=new GetConnection();
//                Connection conn=connect.getConnection();
//                ps=conn.prepareStatement("DELETE FROM customer where customerName=?");
//                ps.setString(1,cust.custName);
//
//                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null,"Deleted Sucessfully");
//
//            }
//        }
//
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
//    }
}
