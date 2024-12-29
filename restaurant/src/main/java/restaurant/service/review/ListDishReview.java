package restaurant.service.review;

import restaurant.models.Dish;
import restaurant.models.DishReview;
import restaurant.models.Menu;
import restaurant.models.Restaurant;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;
import restaurant.utils.DishUtils;
import restaurant.utils.RestaurantUtils;

import java.util.List;

public class ListDishReview implements ICommand<Void> {
    private final RestaurantRepository restaurantRepository;
    private final ConsoleUtils consoleUtils;
    private final RestaurantUtils restaurantUtils = new RestaurantUtils();
    private final DishUtils dishUtils = new DishUtils();

    public ListDishReview(RestaurantRepository restaurantRepository, ConsoleUtils consoleUtils) {
        this.restaurantRepository = restaurantRepository;
        this.consoleUtils = consoleUtils;
    }

    @Override
    public Void execute() {
        String restaurantName = consoleUtils.getString("Introduce el nombre del restaurante: ");
        Restaurant restaurant = restaurantRepository.getRestaurant(restaurantName);
        if (restaurant != null) {
            Menu menu = restaurant.getMenu();
            List<Dish> dishes = menu.getDishes();
            dishUtils.showDishes(dishes);
            int dishIndex = dishUtils.getDishIndex(consoleUtils, dishes, "Introduce el número del plato: ");
            if (dishIndex != -1) {
                Dish dish = dishes.get(dishIndex);
                List<DishReview> reviews = dish.getReviews();
                checkReviews(reviews);
            } else {
                System.out.println("Plato no encontrado");
            }
        } else {
            System.out.println("Restaurante no encontrado");
        }
        return null;
    }

    private static void checkReviews(List<DishReview> reviews) {
        if (reviews.isEmpty()) {
            System.out.println("No hay reviews para este plato.");
        } else {
            for (DishReview review : reviews) {
                System.out.println("Comentario: " + review.getComment());
                System.out.println("Calificación: " + review.getQualification());
                System.out.println("-----");
            }
        }
    }
}