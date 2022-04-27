package com.example.demo.repository;

import com.example.demo.model.Rating;
import com.example.demo.payload.response.AverageResponse;
import com.example.demo.payload.response.RatingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Rating, Long> {

    @Query("Select new com.example.demo.payload.response.RatingResponse(u.username, r.ambiance, r.food, r.service, r.cleanliness, r.drinks) from User u, Rating r " +
            "where r.ambiance >=:ambiance and food >=:food and service >=:service " +
            "and cleanliness >=:cleanliness and drinks >=:drinks and r.user=u.id")
    List<RatingResponse> findByCriteria(@Param("ambiance") int ambiance,
                                        @Param("food") int food,
                                        @Param("service") int service,
                                        @Param("cleanliness") int cleanliness,
                                        @Param("drinks") int drinks);

    @Query("Select new com.example.demo.payload.response.AverageResponse(avg(ambiance), avg(food), avg(service), avg(cleanliness) , avg(drinks), avg(ambiance+ food+ service+ cleanliness+ drinks)/5) from Rating")
    AverageResponse findRatingAverage();

}
