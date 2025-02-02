package edu.neu.csye7374;

public class TechnologyStock extends Stock {
    public TechnologyStock(String id, double price, String description) {
        super(id, price, description);
        baseAlpha = 0.5;
        this.pricingStrategy = new BearMarketStrategy();
    }

    @Override
    protected double calculateNewPrice(double bidPrice) {
        double alpha = getEffectiveAlpha();
        return alpha * bidPrice + (1 - alpha) * price;
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) return 0;
        double lastBid = bids.get(bids.size() - 1).getBidPrice();
        return (int) ((lastBid - price) * 100);
    }
}

