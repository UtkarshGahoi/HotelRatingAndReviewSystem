package org.example;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Hotel hotel=new Hotel("123","knjcdn","");
        Hotel hotel1=new Hotel("1234","kjxscjnd","");
        Hotel.addHotel(hotel);
        Hotel.addHotel(hotel1);
        HotelRating hotelRating=new HotelRating(5.0,"Good", "utkarsh","123");
        HotelRating hotelRating1=new HotelRating(4.0,"Good","bdhsb","1234");
        HotelRating hotelRating5=new HotelRating(3.0,"Good","bkdhsb","1234");
        HotelRating hotelRating6=new HotelRating(4.0,"Good","bdhb","1234");


        Hotel.addHotelRatings(hotelRating);
        Hotel.addHotelRatings(hotelRating1);
        Hotel.addHotelRatings(hotelRating5);
        Hotel.addHotelRatings(hotelRating6);
       List<HotelRating> desc = FilterFeature.getFilterForRatingAndDesc("desc", "3-5");
        System.out.println("printing the list");
        for(int index=0;index<desc.size();index++){
            HotelRating hotelRating2 = desc.get(index);
           System.out.println(hotelRating2.getRating());
        }
        DescribeHotel describeHotel=new DescribeHotel();
        DescHotel descHotel = describeHotel.describeHotel("1234");
//        System.out.println(descHotel.getId());
//        System.out.println(descHotel.getName());
//        System.out.println(descHotel.getLabel() );
//        System.out.println("jcbd");
//        System.out.println(descHotel.getRating());

        List<HotelRating> averageRatingOfHotels = FilterFeature.findAverageRatingOfHotels();
        for(HotelRating hotelRating2:averageRatingOfHotels){
            System.out.println("the rating  is "+hotelRating2.getRating()+" " +" "+"the hotel id is"+hotelRating2.getHotelId());
        }
    }
}