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

    public void setPlus_hotel(String plus_hotel) {
        this.plus_hotel = plus_hotel;
    }
    public static void addHotelRatings(HotelRating hotelRating){
       for(int index=0;index<hotelRatingsList.size();index++){
           HotelRating hotelRating1 = hotelRatingsList.get(index);
           if(hotelRating1.getUserName().equals(hotelRating.getUserName())){
               System.out.println("the hotel we got "+hotelRating.getUserName());
               System.out.println("the hotel we got from the list"+hotelRating1.getUserName());

               hotelRatingsList.remove(hotelRating1);
           }
       }
        hotelRatingsList.add(hotelRating);
    }
    public static List<HotelRating> getHotelRatingsList(){
        return hotelRatingsList ;
    }
    public static void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }
}
