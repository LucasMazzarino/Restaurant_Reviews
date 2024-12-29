package restaurant.service.restaurant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.models.Restaurant;
import restaurant.repository.RestaurantRepository;
import restaurant.utils.ConsoleUtils;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddRestaurantTest {
    private RestaurantRepository repository;
    private ConsoleUtils console;
    private AddRestaurant addRestaurant;

    @BeforeEach
    public void setUp() {
        repository = mock(RestaurantRepository.class);
        console = mock(ConsoleUtils.class);
        addRestaurant = new AddRestaurant(repository, console);
    }

    @Test
    public void testExecute() {
        when(console.getString("Ingrese el nombre del restaurante: ")).thenReturn("Test Restaurant");
        when(console.getString("Ingrese la dirección del restaurante: ")).thenReturn("Test Address");

        Restaurant restaurant = addRestaurant.execute();

        assertNotNull(restaurant);
        assertEquals("Test Restaurant", restaurant.getName());
        assertEquals("Test Address", restaurant.getAddress());
        verify(repository, times(1)).addRestaurant(restaurant);
    }
}