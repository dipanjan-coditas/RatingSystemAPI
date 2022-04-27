package com.example.demo.payload.response;

public class RatingResponse {

    private String name;

    private int ambiance;

    private int food;

    private int service;

    private int cleanliness;

    private int drink;

    public RatingResponse(String name, int ambiance, int food, int service, int cleanliness, int drink) {
        this.name = name;
        this.ambiance = ambiance;
        this.food = food;
        this.service = service;
        this.cleanliness = cleanliness;
        this.drink = drink;
    }

    public RatingResponse(int ambiance, int food, int service, int cleanliness, int drink) {
        this.ambiance = ambiance;
        this.food = food;
        this.service = service;
        this.cleanliness = cleanliness;
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }
}
