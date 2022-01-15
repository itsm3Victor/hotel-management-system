package com.project.hotelmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemno;

    @Column(name="itemname")
    private String itemName;

    @Column(name="Price")
    private String price;

    @Column(name="Type")
    private String type;


    public int getItemNo() {
        return itemno;
    }
    public void setItemNo(int itemNo) {
        this.itemno = itemNo;
    }

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
