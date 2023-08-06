package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private static boolean contains;
    String id;
    String name;

    String plus_hotel;

    static List<HotelRating>hotelRatingsList=new ArrayList<>();
    static List<Hotel>hotelList=new ArrayList<>();

    public Hotel(String id, String name, String plus_hotel) {
        this.id = id;
        this.name = name;
        this.plus_hotel = plus_hotel;
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

    public String getPlus_hotel() {
        return plus_hotel;
    }

}
