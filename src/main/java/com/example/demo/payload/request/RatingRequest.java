package com.example.demo.payload.request;

import com.example.demo.model.User;

import javax.validation.constraints.NotNull;

public class RatingRequest {

    @NotNull
    private int ambiance;

    @NotNull
    private int food;

    @NotNull
    private int service;

    @NotNull
    private int cleanliness;

    @NotNull
    private int drinks;

    private User user;

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
