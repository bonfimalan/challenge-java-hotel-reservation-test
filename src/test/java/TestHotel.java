import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * TestHotel
 */
public class TestHotel {
    @Test
    public void calculatePriceTest1() {
        Hotel hotel = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        String clientType = "Regular";
        ArrayList<String> dayList = new ArrayList<>();
        dayList.add("fri");
        dayList.add("sat");
        dayList.add("sun");
        assertEquals(290, hotel.calculatePrice(clientType, dayList));
    }

    @Test
    public void calculatePriceTest2() {
        Hotel hotel = new Hotel("Bridgewood", 160, 60, 110, 50, 4);
        String clientType = "Regular";
        ArrayList<String> dayList = new ArrayList<>();
        dayList.add("fri");
        dayList.add("sat");
        dayList.add("sun");
        assertEquals(280, hotel.calculatePrice(clientType, dayList));
    }

    @Test
    public void calculatePriceTest3() {
        Hotel hotel = new Hotel("Ridgewood", 220, 150, 100, 40, 4);
        String clientType = "Regular";
        ArrayList<String> dayList = new ArrayList<>();
        dayList.add("fri");
        dayList.add("sat");
        dayList.add("sun");
        assertEquals(520, hotel.calculatePrice(clientType, dayList));
    }
}
