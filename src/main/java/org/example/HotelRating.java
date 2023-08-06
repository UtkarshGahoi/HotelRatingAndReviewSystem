package org.example;

import java.util.ArrayList;
import java.util.List;

public class HotelRating {
    Double rating;
    String review;
    String userName;
    String hotelId;

    public HotelRating(Double rating, String review, String userName, String hotelId) {
        this.rating = rating;
        this.review = review;
        this.userName = userName;
        this.hotelId = hotelId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}