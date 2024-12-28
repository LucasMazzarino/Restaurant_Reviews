// src/main/java/restaurant/service/dish/EditDish.java
package restaurant.service.dish;

import restaurant.models.Dish;
import restaurant.models.Menu;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;
import restaurant.utils.DishUtils;
import restaurant.utils.RestaurantUtils;

import java.util.List;

public class EditDish implements ICommand<Void> {
    private final RestaurantRepository repository;
    private final ConsoleUtils console;
    private final RestaurantUtils restaurantUtils = new RestaurantUtils();
    private final DishUtils dishUtils = new DishUtils();

    public EditDish(RestaurantRepository repository, ConsoleUtils console) {
        this.repository = repository;
        this.console = console;
    }

    @Override
    public Void execute() {
        Menu menu = restaurantUtils.selectMenu(repository, console);
        if (menu != null) {
            List<Dish> dishes = menu.getDishes();
            dishUtils.showDishes(dishes);
            int index = dishUtils.getDishIndex(console, dishes, "Introduce el número del plato que deseas editar: ");
            if (index != -1) {
                Dish dish = dishes.get(index);
                String newName = console.getString("Introduce el nuevo nombre del plato: ");
                String newDescription = console.getString("Introduce la nueva descripción del plato: ");
                double newPrice = console.getDouble("Introduce el nuevo precio del plato: ");
                dish.setName(newName);
                dish.setDescription(newDescription);
                dish.setPrice(newPrice);
                System.out.println("Plato editado: " + newName);
            }
        }
        return null;
    }
}