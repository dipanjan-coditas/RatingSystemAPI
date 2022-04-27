package com.example.demo.repository;

import com.example.demo.model.Rating;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("from User where email = :email")
    User findIdByUsername(@Param("email") String email);

    Boolean existsByUser(User user);
}
