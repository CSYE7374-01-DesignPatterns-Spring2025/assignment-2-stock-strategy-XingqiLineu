package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static final StockMarket instance = new StockMarket();
    private final List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public List<Stock> getStocks() {
        return new ArrayList<>(stocks);
    }

    public static void demo() {
        StockMarket market = StockMarket.getInstance();

        StockFactory techFactory = TechnologyStockFactoryLazySingleton.getInstance();
        StockFactory finFactory = FinancialStockFactoryEagerSingleton.getInstance();

        // Create stocks
        Stock techStock = techFactory.createStock("AAPL", 180.0, "Apple Inc.");
        Stock finStock = finFactory.createStock("JPM", 140.0, "JPMorgan Chase");

        market.addStock(techStock);
        market.addStock(finStock);

        System.out.println("Initial Stocks:");
        market.getStocks().forEach(System.out::println);
        market.getStocks().forEach(stock -> System.out.println("Base Alpha: " + stock.getBaseAlpha()));

        Bid[] techBids1 = {
                new Bid("Investor1", 185.0),
                new Bid("Investor2", 182.0),
                new Bid("Investor3", 188.0),
        };

        Bid[] techBids2 = {
                new Bid("Investor7", 172.0),
                new Bid("Investor8", 178.0),
                new Bid("Investor9", 176.0),
        };

        Bid[] finBids1 = {
                new Bid("Investor4", 146.0),
                new Bid("Investor5", 144.0),
                new Bid("Investor6", 148.0)
        };

        Bid[] finBids2 = {
                new Bid("Investor10", 138.0),
                new Bid("Investor11", 142.0),
                new Bid("Investor12", 140.0)
        };

        System.out.println("\n===Applying BullStrategy===");
        market.getStocks().forEach(stock -> stock.setPricingStrategy(new BullMarketStrategy()));
        market.getStocks().forEach(stock -> System.out.printf("Alpha value: %.2f%n", stock.getEffectiveAlpha()));

        System.out.println("\nTechnology Stock Trading Simulation:");
        for (Bid bid : techBids1) {
            System.out.println("New " + bid);
            techStock.setBid(bid);
            System.out.println("After bid: " + techStock);
        }

        System.out.println("\nFinancial Stock Trading Simulation:");
        for (Bid bid : finBids1) {
            System.out.println("New " + bid);
            finStock.setBid(bid);
            System.out.println("After bid: " + finStock);
        }

        System.out.println("\n===Switching to BearStrategy===");
        market.getStocks().forEach(stock -> stock.setPricingStrategy(new BearMarketStrategy()));
        market.getStocks().forEach(stock -> System.out.printf("Alpha value: %.2f%n", stock.getEffectiveAlpha()));

        System.out.println("\nTechnology Stock Trading Simulation:");
        for (Bid bid : techBids2) {
            System.out.println("New " + bid);
            techStock.setBid(bid);
            System.out.println("After bid: " + techStock);
        }

        System.out.println("\nFinancial Stock Trading Simulation:");
        for (Bid bid : finBids2) {
            System.out.println("New " + bid);
            finStock.setBid(bid);
            System.out.println("After bid: " + finStock);
        }
    }
}

