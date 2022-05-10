import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
/**
 * TestHotelReservation
 */
public class TestHotelReservation {
    @Test
    public void findClientTypeTest1() {
        HotelReservation hotelReservation = new HotelReservation();
        assertEquals("Regular", hotelReservation.findClientType("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)".toCharArray()));
    }

    @Test
    public void findClientTypeTest2() {
        HotelReservation hotelReservation = new HotelReservation();
        assertEquals("Rewards", hotelReservation.findClientType("Rewards: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)".toCharArray()));
    }

    @Test
    public void findDaysTest() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<String> dayList = hotelReservation.findDays("Rewards: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)".toCharArray());
        assertEquals("fri", dayList.get(0));
        assertEquals("sat", dayList.get(1));
        assertEquals("sun", dayList.get(2));
    }
    
    @Test
    public void calculatePricesTest() {
        HotelReservation hotelReservation = new HotelReservation();
        String clientType = "Regular";
        int[] prices = {290, 280, 520};
        ArrayList<String> dayList = new ArrayList<>();
        dayList.add("fri");
        dayList.add("sat");
        dayList.add("sun");
        assertArrayEquals(prices, hotelReservation.calculatePrices(clientType, dayList));
    }

    @Test
    public void findCheapestHotelTest() {
        HotelReservation hotelReservation = new HotelReservation();
        int[] prices = {290, 280, 520};
        assertEquals("Bridgewood", hotelReservation.findCheapestHotel(prices));
    }
}