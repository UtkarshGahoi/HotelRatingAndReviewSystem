package org.example;

import java.math.BigDecimal;
import java.util.List;

public class DescribeHotel {
    public DescHotel describeHotel(String hotelId){
      int sum=0;
      int cnt=0;
        DescHotel describeHotel =new DescHotel("","",0.0,"");
        List<HotelRating> hotelRatingsList = Hotel.getHotelRatingsList();
        System.out.println("the hotel rating list is "+hotelRatingsList.size());
        for(HotelRating hotelRating:hotelRatingsList){
            if(hotelRating.getHotelId().equals(hotelId)){
                System.out.println("got the match");
                //setting again and again to make the object of the class but it will not make any diff.
                 describeHotel.setId(hotelRating.getHotelId());
              sum+=(hotelRating.getRating());
                cnt++;

            }
        }
        double avgRating=(sum*1.0)/(cnt*1.0);
        for (Hotel hotel : Hotel.hotelList) {
            if(hotel.getName().equals(hotelId)){
                describeHotel.setName(hotel.getName());
                describeHotel.setLabel(hotel.getPlus_hotel());
                break;
            }
        }
        describeHotel.setRating(avgRating);
        return describeHotel;
    }
}
