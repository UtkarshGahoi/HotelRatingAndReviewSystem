package Repository;

import org.example.Hotel;
import org.example.HotelRating;

import java.util.List;

public class HotelRepository {
    public Hotel hotel;
    public List<HotelRating>list;
    public List<Hotel>hotelList;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<HotelRating> getList() {
        return list;
    }

    public void setList(List<HotelRating> list) {
        System.out.println("the list for hotel rating is "+list);
        this.list = list;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}

