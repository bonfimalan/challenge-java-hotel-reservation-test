import org.junit.Test;
import static org.junit.Assert.*;

public class FailingTest {
   @Test
   public void test1() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"));
   }
   @Test
   public void test2() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Bridgewood", Hotel.getCheapestHotel("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
   }
   @Test
   public void test3() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)"));
   }
   @Test
   public void test4() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat), 28Mar2009(sun), 29Mar2009(mon), 30Mar2009(tues)"));
   }
   @Test
   public void test5() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Lakewood", Hotel.getCheapestHotel("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed), 19Mar2009(thur)"));
   }
   @Test
   public void test6() {
       HotelReservation Hotel = new HotelReservation();
       assertEquals("Ridgewood", Hotel.getCheapestHotel("Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat), 29Mar2009(sun)"));
   }
}
