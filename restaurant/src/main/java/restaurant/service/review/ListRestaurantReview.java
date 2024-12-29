// src/main/java/restaurant/service/review/ListReview.java
package restaurant.service.review;

import restaurant.models.Restaurant;
import restaurant.models.RestaurantReview;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;

import java.util.List;

public class ListRestaurantReview implements ICommand<Void> {
    private final RestaurantRepository restaurantRepository;
    private final ConsoleUtils consoleUtils;

    public ListRestaurantReview(RestaurantRepository restaurantRepository, ConsoleUtils consoleUtils) {
        this.restaurantRepository = restaurantRepository;
        this.consoleUtils = consoleUtils;
    }

    @Override
    public Void execute() {
        String restaurantName = consoleUtils.getString("Introduce el nombre del restaurante: ");
        Restaurant restaurant = restaurantRepository.getRestaurant(restaurantName);
        if (restaurant != null) {
            List<RestaurantReview> reviews = restaurant.getRestaurantReviews();
            checkReviews(reviews);
        } else {
            System.out.println("Restaurante no encontrado");
        }
        return null;
    }

    private static void checkReviews(List<RestaurantReview> reviews) {
        if (reviews.isEmpty()) {
            System.out.println("No hay reviews para este restaurante.");
        } else {
            for (RestaurantReview review : reviews) {
                System.out.println("Comentario: " + review.getComment());
                System.out.println("Calificación: " + review.getQualification());
                System.out.println("-----");
            }
        }
    }
}