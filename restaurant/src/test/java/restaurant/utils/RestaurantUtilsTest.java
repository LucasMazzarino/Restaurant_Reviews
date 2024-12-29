// src/test/java/restaurant/utils/RestaurantUtilsTest.java
package restaurant.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.models.Menu;
import restaurant.models.Restaurant;
import restaurant.repository.RestaurantRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RestaurantUtilsTest {
    private RestaurantRepository repository;
    private ConsoleUtils console;
    private RestaurantUtils restaurantUtils;
    private Restaurant restaurant;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        repository = mock(RestaurantRepository.class);
        console = mock(ConsoleUtils.class);
        restaurantUtils = new RestaurantUtils();
        restaurant = new Restaurant("Restaurante de Prueba", "123 Calle Prueba");
        menu = new Menu(restaurant);
        restaurant.setMenu(menu);
    }

    @Test
    public void testSelectMenu() {
        when(repository.getRestaurants()).thenReturn(List.of(restaurant));
        when(console.getInteger("Introduce el número del restaurante: ")).thenReturn(1);

        Menu selectedMenu = restaurantUtils.selectMenu(repository, console);

        assertNotNull(selectedMenu);
        assertEquals(restaurant, selectedMenu.getRestaurant());
    }

    @Test
    public void testSelectMenuRestaurantNotFound() {
        when(repository.getRestaurants()).thenReturn(List.of());

        Menu selectedMenu = restaurantUtils.selectMenu(repository, console);

        assertNull(selectedMenu);
    }
}