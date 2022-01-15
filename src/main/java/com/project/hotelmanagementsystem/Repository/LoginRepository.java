package com.project.hotelmanagementsystem.Repository;

import com.project.hotelmanagementsystem.Entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
    @Query(value = "SELECT * FROM login WHERE username= :username AND password= :password", nativeQuery = true)
    String loginVerification(
            @Param("username") String username,
            @Param("password") String password
    );
}
