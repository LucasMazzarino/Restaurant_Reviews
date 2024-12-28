// src/main/java/restaurant/Model/Dish.java
package restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private String description;
    private double price;
    private List<DishReview> reviews = new ArrayList<>();
    private double averageRating;

    public Dish(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReviews(List<DishReview> reviews) {
        this.reviews = reviews;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public List<DishReview> getReviews() {
        return reviews;
    }

    public double calculateAverageRating() {
        double total = 0;
        for (DishReview review : reviews) {
            total += review.getQualification();
        }
        averageRating = total / reviews.size();
        return averageRating;
    }

    public double getAverageRating() {
        return averageRating;
    }
}