package restaurant.repository;

import restaurant.models.Restaurant;

import java.util.LinkedList;
import java.util.List;

public class RestaurantRepository {
    private static RestaurantRepository instance;
    private List<Restaurant> restaurants;

    private RestaurantRepository() {
        restaurants = new LinkedList<>();
    }

    public static synchronized RestaurantRepository getInstance() {
        if (instance == null) {
            instance = new RestaurantRepository();
        }
        return instance;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant getRestaurant(String name) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Boolean removeRestaurant(Restaurant restaurant) {
        return restaurants.remove(restaurant);
    }

}
