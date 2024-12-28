// src/main/java/restaurant/Model/Restaurant.java
package restaurant.models;

import restaurant.observer.IObserver;

import java.util.LinkedList;
import java.util.List;

public class Restaurant implements IObserver {
    private String name;
    private String address;
    private Menu menu;
    private List<RestaurantReview> restaurantReviews = new LinkedList<>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addReview(RestaurantReview review) {
        restaurantReviews.add(review);
    }

    public List<RestaurantReview> getRestaurantReviews() {
        return restaurantReviews;
    }

    public void setRestaurantReviews(List<RestaurantReview> restaurantReviews) {
        this.restaurantReviews = restaurantReviews;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to Restaurant: " + message);
    }
}