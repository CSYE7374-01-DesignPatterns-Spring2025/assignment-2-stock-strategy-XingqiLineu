package edu.neu.csye7374;

public class TechnologyStock extends Stock {
    public TechnologyStock(String id, double price, String description) {
        super(id, price, description);
        this.pricingStrategy = new BearMarketStrategy();
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) return 0;
        double lastBid = bids.get(bids.size() - 1).getBidPrice();
        return (int) ((lastBid - price) * 100);
    }
}

