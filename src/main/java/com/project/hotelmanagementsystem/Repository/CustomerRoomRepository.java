package com.project.hotelmanagementsystem.Repository;

import com.project.hotelmanagementsystem.Entity.Restaurant;
import com.project.hotelmanagementsystem.Entity.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRoomRepository extends JpaRepository<room, Integer> {
    @Query(value="SELECT * FROM restaurant where Type='MEAL' ORDER BY itemName ASC ", nativeQuery = true)
    List<Restaurant> FillCombo1();

    @Query(value="SELECT * FROM restaurant where Type='DRINK' ORDER BY itemName ASC", nativeQuery = true)
    List<Restaurant> FillCombo2();

    @Query(value="SELECT * FROM restaurant where Type='MEAL'", nativeQuery = true)
    List<Restaurant> FillDishes();

    @Query(value="SELECT * FROM restaurant where Type='DRINK'", nativeQuery = true)
    List<Restaurant> FillDrinks();

    @Query(value="SELECT Price FROM restaurant WHERE itemName = :meals", nativeQuery = true)
    String calculateAmount(
            @Param("meals") String meals
    );

    @Modifying
    @Query(value="INSERT INTO restaurantcustomer (custName,custAddr,Phone,Meal,Drink,Price,status) VALUES (:name,:addr,:phone,:comboBox_Dish,:comboBox_Drink,:totalA,:status)", nativeQuery = true)
    void addToDatabase(
            @Param("name") String name,
            @Param("addr") String addr,
            @Param("phone") String phone,
            @Param("comboBox_Dish") String comboBox_Dish,
            @Param("comboBox_Drink") String comboBox_Drink,
            @Param("totalA") String totalA,
            @Param("status") String status
    );

    @Modifying
    @Query(value="UPDATE restaurantcustomer SET status = 1 where custName=:name", nativeQuery = true)
    void checkOut(
            @Param("name") String name
    );
}
