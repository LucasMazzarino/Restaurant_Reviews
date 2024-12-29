
package restaurant.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewTest {
    private Review review;

    @BeforeEach
    public void setUp() {
        review = new Review("Great food!", 4.5);
    }

    @Test
    public void testGetComment() {
        assertEquals("Great food!", review.getComment());
    }

    @Test
    public void testGetQualification() {
        assertEquals(4.5, review.getQualification());
    }
}