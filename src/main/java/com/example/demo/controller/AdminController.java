package com.example.demo.controller;

import com.example.demo.payload.response.ApiResponse;
import com.example.demo.payload.response.AverageResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.payload.response.RatingResponse;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/getRating")
    public ResponseEntity<?> findRating(@RequestParam(name = "ambiance", defaultValue = "0") int ambiance,
                                        @RequestParam(name = "food", defaultValue = "0") int food,
                                        @RequestParam(name = "service", defaultValue = "0") int service,
                                        @RequestParam(name = "cleanliness", defaultValue = "0") int cleanliness,
                                        @RequestParam(name = "drinks", defaultValue = "0") int drinks) {
        List<RatingResponse> rating = adminRepository.findByCriteria(ambiance, food, service, cleanliness, drinks);

        return new ResponseEntity<>(new ApiResponse(rating, new MessageResponse("null")), HttpStatus.CREATED);
    }

    @GetMapping("/average")
    public ResponseEntity<?> findRatingForEachCriteria() {
        AverageResponse averageResponses = adminRepository.findRatingAverage();
        return new ResponseEntity<>(new ApiResponse(averageResponses, "null"), HttpStatus.CREATED);
    }

}
