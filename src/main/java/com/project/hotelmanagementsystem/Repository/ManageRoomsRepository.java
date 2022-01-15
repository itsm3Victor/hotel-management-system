package com.project.hotelmanagementsystem.Repository;

import com.project.hotelmanagementsystem.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageRoomsRepository extends JpaRepository<RoomEntity, Integer> {
    @Query(value="SELECT * FROM room", nativeQuery = true)
    List<RoomEntity> displayRooms();

    @Modifying
    @Query(value="INSERT INTO room(roomType,bedType,Price) VALUES (:r1,:r2,:r3)", nativeQuery = true)
    void addRooms(
            @Param("r1") String d1,
            @Param("r2") String d2,
            @Param("r3") int d3
    );

    @Modifying
    @Query(value="UPDATE room SET roomType=:r1, bedType=:r2, Price=:r3 where roomNo=:no", nativeQuery = true)
    void updateRooms(
            @Param("r1") String d1,
            @Param("r2") String d2,
            @Param("r3") int d3,
            @Param("no") String no
    );

    @Modifying
    @Query(value="DELETE FROM room  where roomNo=:no", nativeQuery = true)
    void deleteRooms(
            @Param("no") String no
    );
}
