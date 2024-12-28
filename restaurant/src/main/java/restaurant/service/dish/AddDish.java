// src/main/java/restaurant/service/dish/AddDish.java
package restaurant.service.dish;

import restaurant.models.Dish;
import restaurant.models.Menu;
import restaurant.repository.RestaurantRepository;
import restaurant.service.Interfaces.ICommand;
import restaurant.utils.ConsoleUtils;
import restaurant.utils.RestaurantUtils;

public class AddDish implements ICommand<Void> {
    private final RestaurantRepository repository;
    private final ConsoleUtils console;
    private final RestaurantUtils restaurantUtils = new RestaurantUtils();

    public AddDish(RestaurantRepository repository, ConsoleUtils console) {
        this.repository = repository;
        this.console = console;
    }

    @Override
    public Void execute() {
        Menu menu = restaurantUtils.selectMenu(repository, console);
        if (menu != null) {
            String name = console.getString("Introduce el nombre del plato: ");
            String description = console.getString("Introduce la descripción del plato: ");
            double price = console.getDouble("Introduce el precio del plato: ");
            Dish dish = new Dish(name, description, price);
            menu.addDish(dish);
            System.out.println("Plato añadido: " + name);
        }
        return null;
    }
}