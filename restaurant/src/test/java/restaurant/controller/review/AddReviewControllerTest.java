package restaurant.controller.review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import restaurant.service.review.AddReview;
import restaurant.models.Review;

import static org.mockito.Mockito.*;

public class AddReviewControllerTest {
    private AddReview addReview;
    private AddReviewController addReviewController;

    @BeforeEach
    public void setUp() {
        addReview = mock(AddReview.class);
        addReviewController = new AddReviewController(addReview);
    }

    @Test
    public void testExecute() {
        Review review = new Review("Great food!", 5.0);
        when(addReview.execute()).thenReturn(review);

        addReviewController.execute();

        verify(addReview, times(1)).execute();
    }
}