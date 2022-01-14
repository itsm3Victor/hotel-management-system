package com.project.hotelmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int roomno;

    @Column(name="roomtype")
    public String roomType;

    @Column(name="bedtype")
    public String bedtype;

    @Column(name="Price")
    public int Price;

    public int status;

    room()
    {

    }

    public room(int roomNo, String roomType, String bedtype, int price) {
        super();
        this.roomno = roomNo;
        this.roomType = roomType;
        this.bedtype = bedtype;
        Price = price;
        this.status=0;
    }

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

    boolean isVacant(room r)
    {
        if(r.status==1)
            return false;
        else return true;

    }

    void displayDetails()
    {
        System.out.println("Room No : "+this.roomno);
        System.out.println("Room Type : "+this.roomType);
        System.out.println("Bed type : "+this.bedtype);
        System.out.println("Price : "+this.Price);
        if(status==1)
            System.out.println("Reserved");
        else System.out.println("Vacant");

    }

    void vacateRoom(int rno)
    {
        int i;
        for(i=0;i<5;i++)
        {
            if(this.roomno ==rno)
                this.status=0;
        }
    }

//    public void addRooms(String oper,room r)
//    {
//        PreparedStatement ps = null;
//        ResultSet result = null;
//        try {
//            if(oper=="i")
//            {
//                GetConnection connect=new GetConnection();
//                Connection conn=connect.getConnection();
//                ps=conn.prepareStatement("INSERT INTO room(roomNo, roomType, bedType, Price) VALUES (?,?,?,?)");
//                //   ps.setString(1,r.roomNo);
//                //  ps.setString(2,cust.addr);
//                // ps.setString(3,cust.phone);
//                //  ps.setString(4,cust.Type);
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
}
