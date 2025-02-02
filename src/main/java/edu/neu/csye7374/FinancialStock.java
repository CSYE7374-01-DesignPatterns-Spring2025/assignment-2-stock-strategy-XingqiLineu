package edu.neu.csye7374;

public class FinancialStock extends Stock {
    public FinancialStock(String id, double price, String description) {
        super(id, price, description);
        baseAlpha = 0.7;
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
        double avgBid = bids.stream()
                .mapToDouble(Bid::getBidPrice)
                .average()
                .orElse(0.0);
        return (int) ((avgBid - price) * 100);
    }
}

