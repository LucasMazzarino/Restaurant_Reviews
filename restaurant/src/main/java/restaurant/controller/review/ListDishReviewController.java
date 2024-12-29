// src/main/java/restaurant/controller/review/ListDishReviewController.java
package restaurant.controller.review;

import restaurant.controller.interfaces.IController;
import restaurant.service.review.ListDishReview;

public class ListDishReviewController implements IController {
    private final ListDishReview command;

    public ListDishReviewController(ListDishReview command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}