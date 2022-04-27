package com.example.demo.payload.response;

public class AverageResponse {

    private double ambiance;

    private double food;

    private double service;

    private double cleanliness;

    private double drink;

    private double overallRating;

    public AverageResponse(double ambiance, double food, double service, double cleanliness, double drink, double overallRating) {
        this.ambiance = ambiance;
        this.food = food;
        this.service = service;
        this.cleanliness = cleanliness;
        this.drink = drink;
        this.overallRating = overallRating;
    }

    public double getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(double ambiance) {
        this.ambiance = ambiance;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getDrink() {
        return drink;
    }

    public void setDrink(double drink) {
        this.drink = drink;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }
}
