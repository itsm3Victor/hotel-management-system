package com.project.hotelmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int roomno;

    @Column(name="roomtype")
    public String roomType;

    @Column(name="bedtype")
    public String bedtype;

    @Column(name="Price")
    public int Price;

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

}
