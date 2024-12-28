// src/main/java/restaurant/Model/Menu.java
package restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Restaurant restaurant;
    private List<Dish> dishes;

    public Menu(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.dishes = new ArrayList<>();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }
}