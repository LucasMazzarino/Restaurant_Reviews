//package restaurant.service.dish;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import restaurant.models.Dish;
//import restaurant.models.Menu;
//import restaurant.models.Restaurant;
//import restaurant.repository.RestaurantRepository;
//import restaurant.utils.ConsoleUtils;
//import restaurant.utils.RestaurantUtils;
//
//import static org.mockito.Mockito.*;
//
//public class AddDishTest {
//    private RestaurantRepository repository;
//    private ConsoleUtils console;
//    private RestaurantUtils restaurantUtils;
//    private AddDish addDish;
//    private Menu menu;
//    private Restaurant restaurant;
//
//    @BeforeEach
//    public void setUp() {
//        repository = mock(RestaurantRepository.class);
//        console = mock(ConsoleUtils.class);
//        restaurantUtils = mock(RestaurantUtils.class);
//        addDish = new AddDish(repository, console, restaurantUtils);
//        menu = mock(Menu.class);
//        restaurant = new Restaurant("Restaurante de Prueba", "123 Calle Prueba");
//
//        when(restaurantUtils.selectMenu(repository, console)).thenReturn(menu);
//    }
//
//    @Test
//    public void testExecute() {
//        when(console.getString("Introduce el nombre del plato: ")).thenReturn("Pasta");
//        when(console.getString("Introduce la descripción del plato: ")).thenReturn("Deliciosa pasta con salsa de tomate");
//        when(console.getDouble("Introduce el precio del plato: ")).thenReturn(12.99);
//
//        addDish.execute();
//
//        verify(menu).addDish(any(Dish.class));
//        verify(console).getString("Introduce el nombre del plato: ");
//        verify(console).getString("Introduce la descripción del plato: ");
//        verify(console).getDouble("Introduce el precio del plato: ");
//    }
//
//    @Test
//    public void testExecuteMenuIsNull() {
//        when(restaurantUtils.selectMenu(repository, console)).thenReturn(null);
//
//        addDish.execute();
//
//        verify(menu, never()).addDish(any(Dish.class));
//    }
//}