package restaurant.service.review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.Interface.IReview;
import restaurant.models.*;
import restaurant.repository.RestaurantRepository;
import restaurant.utils.ConsoleUtils;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddReviewTest {
    private RestaurantRepository repository;
    private ConsoleUtils console;
    private AddReview addReview;

    @BeforeEach
    public void setUp() {
        repository = mock(RestaurantRepository.class);
        console = mock(ConsoleUtils.class);
        addReview = new AddReview(repository, console);
    }

    @Test
    public void testExecuteWithRestaurantReview() {
        when(console.getString("¿Deseas añadir una reseña a un restaurante o a un plato? (restaurant/dish): ")).thenReturn("restaurant");
        when(console.getString("Introduce el nombre del restaurante: ")).thenReturn("Test Restaurant");
        when(console.getString("Introduce tu comentario: ")).thenReturn("Great food!");
        when(console.getDouble("Introduce tu calificación (0-5): ")).thenReturn(5.0);
        Restaurant restaurant = new Restaurant("Test Restaurant", "Test Address");
        when(repository.getRestaurant("Test Restaurant")).thenReturn(restaurant);

        IReview review = addReview.execute();

        assertNotNull(review);
        assertEquals("Great food!", review.getComment());
        assertEquals(5.0, review.getQualification());
        verify(repository, times(1)).getRestaurant("Test Restaurant");
        verify(console, times(1)).getString("¿Deseas añadir una reseña a un restaurante o a un plato? (restaurant/dish): ");
        verify(console, times(1)).getString("Introduce el nombre del restaurante: ");
        verify(console, times(1)).getString("Introduce tu comentario: ");
        verify(console, times(1)).getDouble("Introduce tu calificación (0-5): ");
    }

//    @Test
//    public void testExecuteWithDishReview() {
//        when(console.getString("¿Deseas añadir una reseña a un restaurante o a un plato? (restaurant/dish): ")).thenReturn("dish");
//        when(console.getString("Introduce el nombre del restaurante: ")).thenReturn("Test Restaurant");
//        when(console.getString("Introduce el nombre del plato: ")).thenReturn("Test Dish");
//        when(console.getString("Introduce tu comentario: ")).thenReturn("Delicious!");
//        when(console.getDouble("Introduce tu calificación (0-5): ")).thenReturn(4.5);
//        Restaurant restaurant = new Restaurant("Test Restaurant", "Test Address");
//        Menu menu = new Menu(restaurant);
//        Dish dish = new Dish("Test Dish", "Test Description", 10.0);
//        menu.setDishes(Arrays.asList(dish));
//        restaurant.setMenu(menu);
//        when(repository.getRestaurant("Test Restaurant")).thenReturn(restaurant);
//
//        IReview review = addReview.execute();
//
//        assertNotNull(review);
//        assertEquals("Delicious!", review.getComment());
//        assertEquals(4.5, review.getQualification());
//        assertTrue(true);
//        verify(repository, times(1)).getRestaurant("Test Restaurant");
//        verify(console, times(1)).getString("¿Deseas añadir una reseña a un restaurante o a un plato? (restaurant/dish): ");
//        verify(console, times(1)).getString("Introduce el nombre del restaurante: ");
//        verify(console, times(1)).getString("Introduce el nombre del plato: ");
//        verify(console, times(1)).getString("Introduce tu comentario: ");
//        verify(console, times(1)).getDouble("Introduce tu calificación (0-5): ");
//    }
}