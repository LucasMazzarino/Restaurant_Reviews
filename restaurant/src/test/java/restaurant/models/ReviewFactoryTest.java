package restaurant.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewFactoryTest {
    private Restaurant restaurant;
    private Dish dish;

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant("Restaurante de Prueba", "123 Calle Prueba");
        dish = new Dish("Pasta", "Deliciosa pasta con salsa de tomate", 12.99);
    }

    @Test
    public void testCreateRestaurantReview() {
        RestaurantReview review = ReviewFactory.createRestaurantReview("¡Excelente!", 5.0, restaurant);

        assertEquals("¡Excelente!", review.getComment());
        assertEquals(5.0, review.getQualification());
        assertEquals(restaurant, review.getRestaurant());
    }

    @Test
    public void testCreateDishReview() {
        DishReview review = ReviewFactory.createDishReview("¡Sabroso!", 4.5, dish);

        assertEquals("¡Sabroso!", review.getComment());
        assertEquals(4.5, review.getQualification());
        assertEquals(dish, review.getDish());
    }
}