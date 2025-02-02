package edu.neu.csye7374;

public class BullMarketStrategy implements PricingStrategy {
    @Override
    public double adjustAlpha(double baseAlpha) {
        return baseAlpha * 1.2;
    }}
