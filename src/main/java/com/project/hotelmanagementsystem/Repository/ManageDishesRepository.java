package com.project.hotelmanagementsystem.Repository;

import com.project.hotelmanagementsystem.Entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageDishesRepository extends JpaRepository <RestaurantEntity,Integer> {
    @Query(value="SELECT * FROM restaurant", nativeQuery = true)
    List<RestaurantEntity> displayDishes();

    @Modifying
    @Query(value="INSERT INTO restaurant(itemName,Price,Type) VALUES (:d1,:d2,:d3)", nativeQuery = true)
    void addDishes(
            @Param("d1") String d1,
            @Param("d2") String d2,
            @Param("d3") String d3
    );

    @Modifying
    @Query(value="UPDATE restaurant SET itemName=:d1, Price=:d2, Type=:d3 where itemno=:no", nativeQuery = true)
    void updateDishes(
            @Param("d1") String d1,
            @Param("d2") String d2,
            @Param("d3") String d3,
            @Param("no") String no
    );

    @Modifying
    @Query(value="DELETE FROM restaurant  where itemNo=:no", nativeQuery = true)
    void deleteDishes(
            @Param("no") String no
    );
}
