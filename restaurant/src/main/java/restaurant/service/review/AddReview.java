package restaurant.service.review;

import restaurant.models.*;
import restaurant.observer.ReviewNotifier;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;
import restaurant.utils.RestaurantUtils;
import restaurant.utils.DishUtils;
import restaurant.utils.ReviewUtils;

import java.util.List;

public class AddReview implements ICommand<Review> {
    private final RestaurantRepository restaurantRepository;
    private final ConsoleUtils consoleUtils;
    private final RestaurantUtils restaurantUtils = new RestaurantUtils();
    private final DishUtils dishUtils = new DishUtils();
    private final ReviewUtils reviewUtils = new ReviewUtils();

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
            addRestaurantReview(comment, qualification);
        } else if (reviewType.equalsIgnoreCase("dish")) {
            addDishReview(comment, qualification);
        } else {
            System.out.println("Tipo de review no válido");
        }
        return null;
    }

    private void addRestaurantReview(String comment, Double qualification) {
        Restaurant restaurant = reviewUtils.getRestaurant(restaurantRepository, consoleUtils);
        if (restaurant != null) {
            restaurant.addObserver(new ReviewNotifier());
            RestaurantReview review = ReviewFactory.createRestaurantReview(comment, qualification, restaurant);
            restaurant.addReview(review);
            System.out.println("Review añadida al restaurante " + restaurant.getName());
        } else {
            System.out.println("Restaurante no encontrado");
        }
    }

    private void addDishReview(String comment, Double qualification) {
        Restaurant restaurant = reviewUtils.getRestaurant(restaurantRepository, consoleUtils);
        if (restaurant != null) {
            Menu menu = restaurant.getMenu();
            menu.addObserver(new ReviewNotifier());
            List<Dish> dishes = menu.getDishes();
            dishUtils.showDishes(dishes);
            int dishIndex = dishUtils.getDishIndex(consoleUtils, dishes, "Introduce el número del plato: ");
            if (dishIndex != -1) {
                Dish dish = dishes.get(dishIndex);
                DishReview review = ReviewFactory.createDishReview(comment, qualification, dish);
                menu.addReview(review); // Use the addReview method of Menu
                System.out.println("Review añadida al plato " + dish.getName());
            } else {
                System.out.println("Plato no encontrado");
            }
        } else {
            System.out.println("Restaurante no encontrado");
        }
    }
}