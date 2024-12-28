// src/main/java/restaurant/Model/Review.java
package restaurant.models;

public abstract class Review {
    private String comment;
    private Double qualification;

    public Review(String comment, Double qualification) {
        this.comment = comment;
        this.qualification = qualification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }
}