package org.example;

public class DescHotel {
    String id;
    String name;
    Double rating;
    String label;

    public DescHotel(String id, String name, Double rating, String label) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
