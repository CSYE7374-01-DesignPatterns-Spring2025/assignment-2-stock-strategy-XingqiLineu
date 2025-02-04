package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements Tradable {
    protected String id;
    protected double price;
    protected String description;
    protected List<Bid> bids;

    protected PricingStrategy pricingStrategy;
    protected double baseAlpha;

    public Stock(String id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.bids = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f (Metric: %d)",
                id, price, getMetric());
    }

    @Override
    public void setBid(Bid bid) {
        bids.add(bid);
        price = calculateNewPrice(bid.getBidPrice());
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    protected double getEffectiveAlpha() {
        return pricingStrategy.adjustAlpha(baseAlpha);
    }

    public double getBaseAlpha() {
        return baseAlpha;
    }

    protected abstract double calculateNewPrice(double bidPrice);
}

