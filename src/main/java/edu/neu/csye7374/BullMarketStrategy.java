package edu.neu.csye7374;

public class BullMarketStrategy implements PricingStrategy {
    @Override
    public double calculateNewPrice(double currentPrice) {
        return currentPrice * (1 + 0.05 + Math.random() * 0.1);
    }
}
