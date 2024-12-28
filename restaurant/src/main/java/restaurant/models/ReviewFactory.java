// src/main/java/restaurant/Model/ReviewFactory.java
package restaurant.models;

public class ReviewFactory {
    public static RestaurantReview createRestaurantReview(String comment, Double qualification, Restaurant restaurant) {
        return new RestaurantReview(comment, qualification, restaurant);
    }

    public static DishReview createDishReview(String comment, Double qualification, Dish dish) {
        return new DishReview(comment, qualification, dish);
    }
}