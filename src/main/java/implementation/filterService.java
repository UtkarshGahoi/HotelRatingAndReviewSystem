package implementation;

import Repository.HotelRepository;
import org.example.HotelRating;
import service.filterservice;

import java.util.*;

public class filterService implements filterservice {


    private HotelRepository hotelRepository;
    public filterService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public List<HotelRating> getFilterForRatingAndDesc(String order, String range) {
        String[] ratings = range.split("-");

        if (order.equalsIgnoreCase("desc")) {
            System.out.println("GETTING THE DESCENDING ORDER");
            List<HotelRating> listAfterFilter = new ArrayList<>();
            int rating1 = Integer.parseInt(ratings[0]);
            int rating2 = Integer.parseInt(ratings[1]);
            for (HotelRating hotelRating : this.hotelRepository.getList()) {
                if (hotelRating.getRating() >= rating1 && hotelRating.getRating() <= rating2) {
                    listAfterFilter.add(hotelRating);
                }
            }
            Collections.sort(listAfterFilter, new Comparator<HotelRating>() {
                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    int compare = Double.compare(p2.getRating(), p1.getRating());
                    return compare;
                }
            });

            return listAfterFilter;
        } else if ((order.equalsIgnoreCase("") && range.equalsIgnoreCase("")) || order.equalsIgnoreCase("")) {
            List<HotelRating> hotelList = hotelRepository.getList();
            List<HotelRating> listAfterFilter = new ArrayList<>();
            int rating1 = Integer.parseInt(ratings[0]);
            int rating2 = Integer.parseInt(ratings[1]);
            for (HotelRating hotelRating : hotelList) {
                if (hotelRating.getRating() >= rating1 || hotelRating.getRating() <= rating2) {
                    listAfterFilter.add(hotelRating);
                }
            }
            Collections.sort(listAfterFilter, new Comparator<HotelRating>() {
                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    return (int) (p1.getRating() + p2.getRating());
                }
            });
            return listAfterFilter;
        } else if (order.equalsIgnoreCase("asce")) {
            System.out.println("printing the asceding order");

            List<HotelRating> hotelList = hotelRepository.getList();
            List<HotelRating> listAfterFilter = new ArrayList<>();
            int rating1 = Integer.parseInt(ratings[0]);
            int rating2 = Integer.parseInt(ratings[1]);
            for (HotelRating hotelRating : hotelList) {
                if (hotelRating.getRating() >= rating1 && hotelRating.getRating() <= rating2) {
                    listAfterFilter.add(hotelRating);
                }
            }

            Collections.sort(listAfterFilter, new Comparator<HotelRating>() {
                @Override
                public int compare(HotelRating p1, HotelRating p2) {
                    return (int) (p1.getRating() - p2.getRating());
                }
            });
            return listAfterFilter;

        } else if (order.equalsIgnoreCase("recent")) {
            List<HotelRating> hotelRatingsList = hotelRepository.getList();
            Collections.reverse(hotelRatingsList);
            return hotelRatingsList;
        }
        return hotelRepository.getList();

    }

    @Override
    public List<HotelRating> findAverageRatingOfHotels() {

        Map<String, Double> sortedList = getSortedList(this.hotelRepository.getList());
        Map<String, Integer> occOfHotel = getOccOfHotel(this.hotelRepository.getList());
        Map<String, Double> map = new HashMap<>();
        for (Map.Entry<String, Double> entry : sortedList.entrySet()) {

            String key = entry.getKey();
            Double score = entry.getValue();
            map.put(key, (score * 1.0) / (occOfHotel.get(entry.getKey()) * 1.0));
        }
        List<HotelRating> averageHotelRatingList = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (HotelRating hotelRating :this.hotelRepository.getList()) {
            if (!map1.containsKey(hotelRating.getHotelId())) {
                HotelRating hotelRating1 = new HotelRating(map.get(hotelRating.getHotelId()), hotelRating.getReview(), hotelRating.getUserName(), hotelRating.getHotelId());
                averageHotelRatingList.add(hotelRating1);
                map1.put(hotelRating.getHotelId(), 1);

            }

        }
        Collections.sort(averageHotelRatingList, new Comparator<HotelRating>() {
            @Override
            public int compare(HotelRating p1, HotelRating p2) {
                int compare = Double.compare(p1.getRating(), p2.getRating());
                return compare;
            }
        });
        return averageHotelRatingList;
    }

    public static Map<String, Integer> getOccOfHotel(List<HotelRating> hotelRatings) {
        Map<String, Integer> hotelOcc = new HashMap<>();
        for (HotelRating hotelRating : hotelRatings) {
            if (hotelOcc.containsKey(hotelRating.getHotelId())) {
                hotelOcc.put(hotelRating.getHotelId(), hotelOcc.get(hotelRating.getHotelId()) + 1);
            } else {
                hotelOcc.put(hotelRating.getHotelId(), 1);
            }
        }
        return hotelOcc;
    }

    @Override
    public Map<String, Double> getSortedList(List<HotelRating> hotelRatings) {
        Map<String, Double> averageRatingList = new HashMap<>();
        for (HotelRating hotelRating : hotelRatings) {
            String id = hotelRating.getHotelId();
            if (averageRatingList.containsKey(id)) {
                averageRatingList.put(id, averageRatingList.get(id) + hotelRating.getRating());
            } else {
                averageRatingList.put(id, (double) hotelRating.getRating());
            }
        }
        return averageRatingList;
    }
}
