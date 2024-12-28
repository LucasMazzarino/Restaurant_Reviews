// src/main/java/restaurant/service/dish/RemoveDish.java
package restaurant.service.dish;

import restaurant.models.Dish;
import restaurant.models.Menu;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;
import restaurant.utils.DishUtils;
import restaurant.utils.RestaurantUtils;

import java.util.List;

public class RemoveDish implements ICommand<Void> {
    private final RestaurantRepository repository;
    private final ConsoleUtils console;
    private final RestaurantUtils restaurantUtils = new RestaurantUtils();
    private final DishUtils dishUtils = new DishUtils();

    public RemoveDish(RestaurantRepository repository, ConsoleUtils console) {
        this.repository = repository;
        this.console = console;
    }

    @Override
    public Void execute() {
        Menu menu = restaurantUtils.selectMenu(repository, console);
        if (menu != null) {
            List<Dish> dishes = menu.getDishes();
            dishUtils.showDishes(dishes);
            int index = dishUtils.getDishIndex(console, dishes, "Introduce el número del plato que deseas eliminar: ");
            if (index != -1) {
                Dish dish = dishes.get(index);
                menu.removeDish(dish);
                System.out.println("Plato eliminado: " + dish.getName());
            }
        }
        return null;
    }
}