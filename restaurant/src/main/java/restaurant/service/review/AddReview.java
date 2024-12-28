// src/main/java/restaurant/Service/Review/AddReview.java
package restaurant.service.review;

import restaurant.models.*;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;

public class AddReview implements ICommand<Review> {
    private final RestaurantRepository restaurantRepository;
    private final ConsoleUtils consoleUtils;

    public AddReview(RestaurantRepository restaurantRepository, ConsoleUtils consoleUtils) {
        this.restaurantRepository = restaurantRepository;
        this.consoleUtils = consoleUtils;
    }

    @Override
    public Review execute() {
        String reviewType = consoleUtils.getString("¿Qué tipo de review deseas hacer? (restaurant/dish): ");
        String comment = consoleUtils.getString("Introduce el comentario: ");
        Double qualification = consoleUtils.getDouble("Introduce la calificación: ");

        if (reviewType.equalsIgnoreCase("restaurant")) {
            String restaurantName = consoleUtils.getString("Introduce el nombre del restaurante: ");
            Restaurant restaurant = restaurantRepository.getRestaurant(restaurantName);
            if (restaurant != null) {
                RestaurantReview review = ReviewFactory.createRestaurantReview(comment, qualification, restaurant);
                restaurant.addReview(review);
                System.out.println("Review añadida al restaurante " + restaurantName);
            } else {
                System.out.println("Restaurante no encontrado");
            }
        } else if (reviewType.equalsIgnoreCase("dish")) {
            String dishName = consoleUtils.getString("Introduce el nombre del plato: ");
            Dish dish = new Dish(dishName); // Suponiendo que tienes un constructor que acepta el nombre
            DishReview review = ReviewFactory.createDishReview(comment, qualification, dish);
            dish.getReviews().add(review);
            System.out.println("Review añadida al plato " + dishName);
        } else {
            System.out.println("Tipo de review no válido");
        }
        return null;
    }
}