package edu.neu.csye7374;

public class FinancialStock extends Stock {
    public FinancialStock(String id, double price, String description) {
        super(id, price, description);
        this.pricingStrategy = new BearMarketStrategy();
    }

    @Override
    public int getMetric() {
        if (bids.isEmpty()) return 0;
        double avgBid = bids.stream()
                .mapToDouble(Bid::getBidPrice)
                .average()
                .orElse(0.0);
        return (int)((avgBid - price) * 100);
    }
}

