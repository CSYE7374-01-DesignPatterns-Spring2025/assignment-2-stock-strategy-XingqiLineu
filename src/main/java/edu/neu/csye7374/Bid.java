package edu.neu.csye7374;

public class Bid {
    private final String bidderName;
    private final double bidPrice;

    public Bid(String bidderName, double bidPrice) {
        this.bidderName = bidderName;
        this.bidPrice = bidPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    @Override
    public String toString() {
        return String.format("Bid from %s at $%.2f",
                bidderName, bidPrice);
    }
}

