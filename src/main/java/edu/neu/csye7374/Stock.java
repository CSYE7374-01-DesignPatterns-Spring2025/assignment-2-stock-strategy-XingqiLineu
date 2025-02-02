package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements Tradable {
    protected String id;
    protected double price;
    protected String description;
    protected List<Bid> bids;

    protected PricingStrategy pricingStrategy;

    public Stock(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
    }

    @Override
    public void setBid(Bid bid) {
        bids.add(bid);
        price = (price + bid.getBidPrice()) / 2;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f (Metric: %d)",
                id, price, getMetric());
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    public void updatePrice() {
        this.price = pricingStrategy.calculateNewPrice(this.price);
    }
}

