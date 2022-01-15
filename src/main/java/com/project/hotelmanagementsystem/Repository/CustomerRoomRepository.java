package com.project.hotelmanagementsystem.Repository;

import com.project.hotelmanagementsystem.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRoomRepository extends JpaRepository<RoomEntity, Integer> {
    @Modifying
    @Query(value="INSERT INTO roomcutomer(name,address,phone,roomtype,bedtype,price,status) VALUES (:name,:addr,:phone,:roomtype,:bedtype,:tot,:status)", nativeQuery = true)
    void addToDatabase(
            @Param("name") String name,
            @Param("addr") String addr,
            @Param("phone") String phone,
            @Param("roomtype") String roomtype,
            @Param("bedtype") String bedtype,
            @Param("tot") String tot,
            @Param("status") String status
    );

    @Modifying
    @Query(value="UPDATE roomcutomer SET status = 1 where name=:name", nativeQuery = true)
    void checkOut(
            @Param("name") String name
    );
}
