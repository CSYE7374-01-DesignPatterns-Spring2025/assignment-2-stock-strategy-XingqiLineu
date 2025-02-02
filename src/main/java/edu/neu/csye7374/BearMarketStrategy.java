package edu.neu.csye7374;

public class BearMarketStrategy implements PricingStrategy {
    @Override
    public double adjustAlpha(double baseAlpha) {
        return baseAlpha * 0.8;
    }
}
