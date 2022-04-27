package com.example.demo.controller;

import com.example.demo.model.Rating;
import com.example.demo.model.User;
import com.example.demo.payload.request.RatingRequest;
import com.example.demo.payload.response.ApiResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/rating")
@PreAuthorize("hasRole('USER')")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @PostMapping("/input")
    public ResponseEntity<?> ratingInput(@Valid @RequestBody RatingRequest ratingRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
//      System.out.println(userName);
        User user = ratingRepository.findIdByUsername(userName);

        if (ratingRepository.existsByUser(user)) {
            return new ResponseEntity<>(new ApiResponse(null, new MessageResponse("Error: User Has Already Completed Rating")), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Rating rating = new Rating(ratingRequest.getAmbiance(), ratingRequest.getFood(), ratingRequest.getService(), ratingRequest.getCleanliness(), ratingRequest.getDrinks(), user);
        ratingRepository.save(rating);
        return new ResponseEntity<>(new ApiResponse(null, new MessageResponse("Rating Successfully")), HttpStatus.CREATED);
    }

}
