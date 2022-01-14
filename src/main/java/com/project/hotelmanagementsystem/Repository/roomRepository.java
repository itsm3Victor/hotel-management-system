package com.project.hotelmanagementsystem.Repository;

import com.project.hotelmanagementsystem.Entity.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface roomRepository extends JpaRepository<room, Integer> {
    @Modifying
    @Query(value="INSERT INTO customer (customerName, address, phoneNo, type) VALUES (:custName, :addr, :phone, :Type)", nativeQuery = true)
    void addCustomer(
            @Param("custName") String custName,
            @Param("addr") String addr,
            @Param("phone") String phone,
            @Param("Type") String Type
    );
}
