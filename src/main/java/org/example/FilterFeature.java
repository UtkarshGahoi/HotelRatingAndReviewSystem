package org.example;

import java.util.*;

public class FilterFeature {

    public static List<HotelRating> getFilterForRatingAndDesc(String order,String range) {
        String[] ratings = range.split("-");


        if (order.equalsIgnoreCase("desc"))
        {
            System.out.println("GETTING THE DESCENDING ORDER");
            List<HotelRating> hotelList = Hotel.getHotelRatingsList();
            List<HotelRating> listAfterFilter = new ArrayList<>();
            int rating1= Integer.parseInt(ratings[0]);
            int rating2=Integer.parseInt(ratings[1]);
            for (HotelRating hotelRating : hotelList) {
                if (hotelRating.getRating()>=rating1 || hotelRating.getRating()<=rating2) {
                    listAfterFilter.add(hotelRating);
                }
            }
            Collections.sort(listAfterFilter, new Comparator<HotelRating>() {
                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    int compare = Double.compare(p2.getRating(),p1.getRating());
                    return compare;
//                    return (int) (p1.getRating()+p2.getRating());
                }
            });

            return listAfterFilter;
        }
        else if((order.equalsIgnoreCase("") && range.equalsIgnoreCase("")) ||order.equalsIgnoreCase("")){
            List<HotelRating> hotelList = Hotel.getHotelRatingsList();
            List<HotelRating> listAfterFilter = new ArrayList<>();
            int rating1= Integer.parseInt(ratings[0]);
            int rating2=Integer.parseInt(ratings[1]);
            for (HotelRating hotelRating : hotelList) {
                if (hotelRating.getRating()>=rating1 || hotelRating.getRating()<=rating2) {
                    listAfterFilter.add(hotelRating);
                }
            }
            Collections.sort(listAfterFilter, new Comparator<HotelRating>() {

                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    return (int) (p1.getRating()+p2.getRating());
                }
            });
            return listAfterFilter;
        }
        else if (order.equalsIgnoreCase("asce")){

             List<HotelRating> hotelList = Hotel.getHotelRatingsList();
             List<HotelRating> listAfterFilter = new ArrayList<>();
             int rating1= Integer.parseInt(ratings[0]);
             int rating2=Integer.parseInt(ratings[1]);
             for (HotelRating hotelRating : hotelList) {
                 if (hotelRating.getRating()>=rating1 || hotelRating.getRating()<=rating2) {
                     listAfterFilter.add(hotelRating);
                 }
             }

            Collections.sort(listAfterFilter, new Comparator<HotelRating>() {
                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    return (int) (p1.getRating()-p2.getRating());
                }
            });
             return listAfterFilter;

        }
        else if(order.equalsIgnoreCase("recent")){
            List<HotelRating> hotelRatingsList = Hotel.getHotelRatingsList();
             Collections.reverse(hotelRatingsList);
             return  hotelRatingsList;
        }
        return Hotel.getHotelRatingsList();
        }

        public static List<HotelRating> findAverageRatingOfHotels(){
            List<HotelRating> hotelRatingsList = Hotel.getHotelRatingsList();
////            int sum = hotelRatingsList.stream().fi.mapToInt(HotelRating::getRating).sum();
//            List<HotelRating> sortedStudents = hotelRatingsList.stream()
//                    .sorted(Comparator.comparingDouble(hotelRatingsList::getAverageScore))
//                    .toList();
//            System.out.println("the stream is"+sum);

            Map<String, Double> sortedList = getSortedList(hotelRatingsList);
            Map<String, Integer> occOfHotel = getOccOfHotel(hotelRatingsList);
            Map<String,Double>map=new HashMap<>();
//            System.out.println("the logger is ");
            for (Map.Entry<String, Double> entry : sortedList.entrySet()) {

                String key = entry.getKey();
                Double score = entry.getValue();
//                System.out.println(key + ": " + (score*1.0)/(occOfHotel.get(entry.getKey())*1.0));
//                System.out.println("teh occ is"+occOfHotel.get(entry.getKey()));
                map.put(key,(score*1.0)/(occOfHotel.get(entry.getKey())*1.0));
//                System.out.println(key+" " +" "+ " "+occOfHotel.get(entry.getKey())*1.0);

            }
            List<HotelRating>averageHotelRatingList=new ArrayList<>();
            Map<String,Integer>map1=new HashMap<>();
            for(HotelRating hotelRating:hotelRatingsList){
                if(!map1.containsKey(hotelRating.getHotelId())){
                    HotelRating hotelRating1=new HotelRating(map.get(hotelRating.getHotelId()),hotelRating.getReview(),hotelRating.getUserName(),hotelRating.getHotelId());
                    averageHotelRatingList.add(hotelRating1);
//                    System.out.println("the average rating is ");
//                    System.out.println(hotelRating1.getHotelId()+" "+hotelRating1.getUserName()+" "+hotelRating1.getRating()+" "+hotelRating1.getReview());
                    map1.put(hotelRating.getHotelId(),1);


                }

            }
            Collections.sort(averageHotelRatingList, new Comparator<HotelRating>() {
                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    int compare = Double.compare(p1.getRating(),p2.getRating());
                    return compare;
                }
            });
            return averageHotelRatingList;
            }
        public static Map<String,Double> getSortedList(List<HotelRating> hotelRatinglist){
        Map<String,Double> averageRatingList=new HashMap<>();
        for(HotelRating hotelRating:hotelRatinglist){
            String id=hotelRating.getHotelId();
            if(averageRatingList.containsKey(id)){
                averageRatingList.put(id,averageRatingList.get(id)+hotelRating.getRating());
            }
            else {
                averageRatingList.put(id, (double) hotelRating.getRating());
            }
        }
        return averageRatingList;
        }
        public static Map<String,Integer> getOccOfHotel(List<HotelRating> hotelRatings){
        Map<String,Integer>hotelOcc=new HashMap<>();
        for(HotelRating hotelRating:hotelRatings){
            if(hotelOcc.containsKey(hotelRating.getHotelId())){
                hotelOcc.put(hotelRating.getHotelId(),hotelOcc.get(hotelRating.getHotelId())+1);
            }
            else{
                hotelOcc.put(hotelRating.getHotelId(),1);
            }
        }
        return hotelOcc;
        }
    }