package restaurant.utils;

import restaurant.models.Dish;
import restaurant.models.DishReview;
import restaurant.models.Restaurant;
import restaurant.models.RestaurantReview;
import restaurant.models.ReviewFactory;
import restaurant.repository.RestaurantRepository;

public class ReviewUtils {

    public Restaurant getRestaurant(RestaurantRepository repository, ConsoleUtils console) {
        String restaurantName = console.getString("Introduce el nombre del restaurante: ");
        return repository.getRestaurant(restaurantName);
    }

    public void addRestaurantReview(Restaurant restaurant, String comment, Double qualification) {
        RestaurantReview review = ReviewFactory.createRestaurantReview(comment, qualification, restaurant);
        restaurant.addReview(review);
        System.out.println("Review añadida al restaurante " + restaurant.getName());
    }

    public void addDishReview(Dish dish, String comment, Double qualification) {
        DishReview review = ReviewFactory.createDishReview(comment, qualification, dish);
        dish.getReviews().add(review);
        System.out.println("Review añadida al plato " + dish.getName());
    }
}