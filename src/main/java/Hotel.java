public class Hotel {
    private String name;
    private int regularWeekdayPrice;
    private int regularWeekendPrice;
    private int rewardWeekdayPrice;
    private int rewardWeekendPrice;
    private int rate;

    public Hotel(String name, int regularWeekdayPrice, int regularWeekendPrice, int rewardWeekdayPrice,
            int rewardWeekendPrice, int rate) {
        this.name = name;
        this.regularWeekdayPrice = regularWeekdayPrice;
        this.regularWeekendPrice = regularWeekendPrice;
        this.rewardWeekdayPrice = rewardWeekdayPrice;
        this.rewardWeekendPrice = rewardWeekendPrice;
        this.rate = rate;
    }

    public int calculatePrice(String clientType, String... days) {
        int price = 0;

        for(String day : days) {
            switch(day) {
                // in case it is a weekend day
                case "sat":
                case "sun":
                    price += clientType.equals("Regular") ? regularWeekendPrice : rewardWeekendPrice;
                    break;
                default:
                    price += clientType.equals("Regular") ? regularWeekdayPrice : rewardWeekdayPrice;
            }// end switch
        }// end for

        return price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegularWeekdayPrice() {
        return regularWeekdayPrice;
    }

    public void setRegularWeekdayPrice(int regularWeekdayPrice) {
        this.regularWeekdayPrice = regularWeekdayPrice;
    }

    public int getRegularWeekendPrice() {
        return regularWeekendPrice;
    }

    public void setRegularWeekendPrice(int regularWeekendPrice) {
        this.regularWeekendPrice = regularWeekendPrice;
    }

    public int getRewardWeekdayPrice() {
        return rewardWeekdayPrice;
    }

    public void setRewardWeekdayPrice(int rewardWeekdayPrice) {
        this.rewardWeekdayPrice = rewardWeekdayPrice;
    }

    public int getRewardWeekendPrice() {
        return rewardWeekendPrice;
    }

    public void setRewardWeekendPrice(int rewardWeekendPrice) {
        this.rewardWeekendPrice = rewardWeekendPrice;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
