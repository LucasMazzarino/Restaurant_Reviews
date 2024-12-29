package restaurant.models;

public class Review {
    private String comment;
    private Double qualification;

    public Review(String comment, Double qualification) {
        this.comment = comment;
        this.qualification = qualification;
    }

    public String getComment() {
        return comment;
    }

    public Double getQualification() {
        return qualification;
    }
}