package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ratings")
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "ratings"})
    private User user;

    public Rating() {
    }

    public Rating(int ambiance, int food, int service, int cleanliness, int drinks, User user) {
        this.ambiance = ambiance;
        this.food = food;
        this.service = service;
        this.cleanliness = cleanliness;
        this.drinks = drinks;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Rating{" +
                "ambiance=" + ambiance +
                ", food=" + food +
                ", service=" + service +
                ", cleanliness=" + cleanliness +
                ", drinks=" + drinks +
                ", user=" + user +
                '}';
    }
}
