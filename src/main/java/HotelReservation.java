public class HotelReservation {
    private Hotel[] hotels;

    public HotelReservation() {
        this.hotels = new Hotel[3];
        this.hotels[0] = new Hotel("Lakewood", 110, 90, 80, 80, 3);
        this.hotels[1] = new Hotel("Bridgewood", 160, 60, 110, 50, 4);
        this.hotels[2] = new Hotel("Ridgewood", 220, 150, 100, 40, 4);
    }

    public String getCheapestHotel (String input) {
        String clientType = findClientType(input.toCharArray());

        String[] days = findDays(input.toCharArray());

        int[] prices = calculatePrices(clientType, days);

        String cheapestHotel = findCheapestHotel(prices);

        return cheapestHotel;
    }

    private String findClientType(char[] input) {
        String clientType = "";
        for(char c : input) {
            if (c == ':') 
                break;
            clientType += c;
        }// end for
        return clientType;
    }

    private String[] findDays(char[] input) {
        String[] days = new String[3];
        int dayIndex = 0;

        for(int i=7; i < input.length; i++) {
            if(input[i] == '('){
                i++; // goes to the next char, that is the first char of the day string
                days[dayIndex] = "";
                while (input[i] != ')'){
                    days[dayIndex] += input[i];
                    i++;
                }//end while
                dayIndex++;
            }//end if
        }//end for

        return days;
    }

    private int[] calculatePrices(String clientType, String[] days) {
        int[] prices = new int[3];
        int index = 0;

        for (Hotel hotel: hotels) {
            prices[index] = hotel.calculatePrice(clientType, days);
            index++;
        }            

        return prices;
    }

    private String findCheapestHotel(int[] prices) {
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
