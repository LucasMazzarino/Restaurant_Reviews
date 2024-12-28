
package restaurant;

import restaurant.controller.dish.AddDishController;
import restaurant.controller.dish.EditDishController;
import restaurant.controller.dish.RemoveDishController;
import restaurant.controller.interfaces.IController;
import restaurant.controller.restaurant.AddRestaurantController;
import restaurant.controller.restaurant.EditRestaurantController;
import restaurant.controller.restaurant.RemoveRestaurantController;
import restaurant.controller.review.AddReviewController;
import restaurant.repository.RestaurantRepository;
import restaurant.service.dish.AddDish;
import restaurant.service.dish.EditDish;
import restaurant.service.dish.RemoveDish;
import restaurant.service.review.AddReview;
import restaurant.service.restaurant.AddRestaurant;
import restaurant.service.restaurant.EditRestaurant;
import restaurant.service.restaurant.RemoveRestaurant;
import restaurant.utils.ConsoleUtils;
import restaurant.utils.SeedData;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils consoleUtils = new ConsoleUtils();
        RestaurantRepository restaurantRepository = RestaurantRepository.getInstance();

        SeedData.preloadData(restaurantRepository);

        AddRestaurant addRestaurantCommand = new AddRestaurant(restaurantRepository, consoleUtils);
        RemoveRestaurant removeRestaurantCommand = new RemoveRestaurant(restaurantRepository, consoleUtils);
        AddReview addReviewCommand = new AddReview(restaurantRepository, consoleUtils);
        EditRestaurant editRestaurantCommand = new EditRestaurant(restaurantRepository, consoleUtils);
        AddDish addDishCommand = new AddDish(restaurantRepository, consoleUtils);
        EditDish editDishCommand = new EditDish(restaurantRepository, consoleUtils);
        RemoveDish removeDishCommand = new RemoveDish(restaurantRepository, consoleUtils);


        Map<Integer, IController> controllers = Map.of(
                1, new AddRestaurantController(addRestaurantCommand),
                2, new RemoveRestaurantController(removeRestaurantCommand),
                3, new EditRestaurantController(editRestaurantCommand),
                4, new AddReviewController(addReviewCommand),
                5, new AddDishController(addDishCommand),
                6, new EditDishController(editDishCommand),
                7, new RemoveDishController(removeDishCommand)
        );

        int option;
        do {
            option = consoleUtils.getInteger("Bienvenido \n¿Qué deseas hacer?\n1. Añadir Restaurante\n2. Eliminar Restaurante\n3. Editar Restaurante\n4. Crear Reseña\n5. Añadir Plato\n6. Editar Plato\n7. Eliminar Plato\n8. Salir");
            if (option != 8) {
                controllers.get(option).execute();
            }
        } while (option != 8);
    }
}

