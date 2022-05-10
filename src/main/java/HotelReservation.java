import java.util.ArrayList;

public class HotelReservation {
    private Hotel[] hotels;

    /**
     * Constructor that instantiate the 3 hotels with their name and prices
     */
    public HotelReservation() {
        this.hotels = new Hotel[3];
        this.hotels[0] = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        this.hotels[1] = new Hotel("Bridgewood", 160, 60, 110, 50, 4);
        this.hotels[2] = new Hotel("Ridgewood", 220, 150, 100, 40, 5);
    }

    /**
     * Gets the cheapest hotel for that input
     * 
     * @param input The message with the client type and the days to reservation
     * 
     * @return The name of the cheapest hotel
     */
    public String getCheapestHotel (String input) {
        String clientType = findClientType(input.toCharArray());

        ArrayList<String> days = findDays(input.toCharArray());

        int[] prices = calculatePrices(clientType, days);

        String cheapestHotel = findCheapestHotel(prices);

        return cheapestHotel;
    }

    /**
     * Methood to find the client type, that is in the beginning of the input
     * 
     * @param input A char arrray with the whole input message
     * 
     * @return The client type ("Regular" or "Reward")
     */
    public String findClientType(char[] input) {
        String clientType = "";
        for(char character : input) {
            if (character == ':') 
                break;
            clientType += character;
        }// end for
        return clientType;
    }

    /**
     * Methood to find the name of the days the client chose
     * 
     * @param input A char arrray with the whole input message
     * 
     * @return The days the client chose
     */
    public ArrayList<String> findDays(char[] input) {
        ArrayList<String> days = new ArrayList<>();
        String temp;

        // threre's no need to start the i with 0
        for(int i=7; i < input.length; i++) {
            if(input[i] == '('){
                i++; // goes to the next char, that is the first char of the day string
                temp = "";
                while (input[i] != ')'){
                    temp += input[i];
                    i++;
                }//end while
                days.add(temp);
            }//end if
        }//end for

        return days;
    }

    /**
     * Use the methood {@link Hotel#calculatePrice(String, String...)} from {@link Hotel}
     * to calculate the price of the reservation in the 3 hotels
     * 
     * @param clientType A String with the type of the client
     * @param days The days the client chose
     * 
     * @return An int array with the price of each hotel, the position in the int array is
     *         relative to the Hotel array position
     */
    public int[] calculatePrices(String clientType, ArrayList<String> days) {
        int[] prices = new int[3];
        int index = 0;

        for (Hotel hotel: hotels) {
            prices[index] = hotel.calculatePrice(clientType, days);
            index++;
        }            

        return prices;
    }

    /**
     * Loops through the prices and finds the min between them, if there're two equals prices the
     * hotel with the bigger rate will be choose
     * 
     * @param prices A int array with the price of each hotel, the position in the int array is
     *               relative to the Hotel array position
     * 
     * @return The name of the cheapest hotel
     */
    public String findCheapestHotel(int[] prices) {
        int chepeastPrice = prices[0];
        int chepeastHotelIndex = 0;
        
        for (int i=1; i<prices.length; i++) {
            if (chepeastPrice == prices[i] && hotels[chepeastHotelIndex].getRate() < hotels[i].getRate()) {
                chepeastPrice = prices[i];
                chepeastHotelIndex = i;
                continue;
            }
            
            if (chepeastPrice > prices[i]) {
                chepeastPrice = prices[i];
                chepeastHotelIndex = i;
            }
        }

        return hotels[chepeastHotelIndex].getName();
    }
}
