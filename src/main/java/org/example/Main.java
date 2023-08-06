package org.example;

import Repository.HotelRepository;
import implementation.filterService;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Hotel>hotelList=new ArrayList<>();

        Hotel hotel=new Hotel("123","knjcdn","");
        Hotel hotel1=new Hotel("1234","kjxscjnd","");
        hotelList.add(hotel1);
        hotelList.add(hotel);
        HotelRating hotelRating=new HotelRating(5.0,"Good", "utkarsh","123");
        HotelRating hotelRating1=new HotelRating(4.0,"Good","bdhsb","1234");
        HotelRating hotelRating5=new HotelRating(3.0,"Good","bkdhsb","1234");
        HotelRating hotelRating6=new HotelRating(4.0,"Good","bdhb","1234");

        List<HotelRating>hotelRatings=new ArrayList<>();
        hotelRatings.add(hotelRating);
        hotelRatings.add(hotelRating1);
        hotelRatings.add(hotelRating5);
        hotelRatings.add(hotelRating6);

        HotelRepository hotelRepository=new HotelRepository();
        hotelRepository.setList(hotelRatings);
        hotelRepository.setHotelList(hotelList);
        System.out.println(hotelRepository.getList());

        filterService filterService=new filterService(hotelRepository);
       List<HotelRating> desc = filterService.getFilterForRatingAndDesc("desc", "3-4");
        System.out.println("printing the list");
        for(int index=0;index<desc.size();index++){
            HotelRating hotelRating2 = desc.get(index);
           System.out.println(hotelRating2.getRating());
        }
        DescribeHotel describeHotel=new DescribeHotel(hotelRepository);
        DescHotel descHotel = describeHotel.describeHotel("1234");
        List<HotelRating> averageRatingOfHotels = filterService.findAverageRatingOfHotels();
        for(HotelRating hotelRating2:averageRatingOfHotels){
            System.out.println("the rating  is "+hotelRating2.getRating()+" " +" "+"the hotel id is"+hotelRating2.getHotelId());
        }
    }
}