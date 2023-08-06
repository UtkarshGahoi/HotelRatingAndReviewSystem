package service;

import org.example.HotelRating;

import java.util.List;
import java.util.Map;

public interface filterservice {
    List<HotelRating> getFilterForRatingAndDesc(String order, String range);
    List<HotelRating> findAverageRatingOfHotels();
    Map<String, Double> getSortedList(List<HotelRating> hotelRatings);
}