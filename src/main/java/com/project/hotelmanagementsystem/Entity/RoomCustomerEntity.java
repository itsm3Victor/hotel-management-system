package com.project.hotelmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="roomcutomer")
public class RoomCustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name="name")
    public String name;

    @Column(name="address")
    public String address;

    @Column(name="phone")
    public String phone;

    @Column(name="roomtype")
    public String roomtype;

    @Column(name="bedtype")
    public String bedtype;

    @Column(name="price")
    public float price;

    @Column(name="status")
    public int status;


    public int getId(){return id;}
    public void setId(int id){this.id = id;};

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    public String getRoomtype(){return roomtype;}
    public void setRoomtype(String roomtype){this.roomtype = roomtype;}

    public String getBedtype(){return bedtype;}
    public void setBedtype(String bedtype){this.bedtype = bedtype;}

    public float getPrice(){return price;}
    public void setPrice(float price){this.price = price;}

    public int getStatus(){return status;}
    public void setStatus(int status){this.status = status;}
}
