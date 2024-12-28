package restaurant.controller.review;

import restaurant.controller.interfaces.IController;
import restaurant.models.Review;
import restaurant.service.review.AddReview;

public class AddReviewController implements IController {
    private final AddReview command;

    public AddReviewController(AddReview command) {
        this.command = command;
    }

    @Override
    public void execute() {
        Review review = command.execute();
        System.out.println("Se agrego la review:");
    }
}
