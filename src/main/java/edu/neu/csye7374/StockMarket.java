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

        TechnologyStock techStock = new TechnologyStock("AAPL", 180.0, "Apple Inc.");
        FinancialStock finStock = new FinancialStock("JPM", 140.0, "JPMorgan Chase");

        market.addStock(techStock);
        market.addStock(finStock);

        System.out.println("Initial Stocks:");
        market.getStocks().forEach(System.out::println);

//        Bid[] techBids = {
//                new Bid("Investor1", 185.0),
//                new Bid("Investor2", 182.0),
//                new Bid("Investor3", 188.0),
//                new Bid("Investor4", 186.0),
//                new Bid("Investor5", 190.0),
//                new Bid("Investor6", 192.0)
//        };
//
//        Bid[] finBids = {
//                new Bid("Investor1", 142.0),
//                new Bid("Investor2", 145.0),
//                new Bid("Investor3", 143.0),
//                new Bid("Investor4", 146.0),
//                new Bid("Investor5", 144.0),
//                new Bid("Investor6", 148.0)
//        };
//
//        System.out.println("\nTechnology Stock Trading Simulation:");
//        for (Bid bid : techBids) {
//            System.out.println("New " + bid);
//            techStock.setBid(bid);
//            System.out.println("After bid: " + techStock);
//        }
//
//        System.out.println("\nFinancial Stock Trading Simulation:");
//        for (Bid bid : finBids) {
//            System.out.println("New " + bid);
//            finStock.setBid(bid);
//            System.out.println("After bid: " + finStock);
//        }

        market.getStocks().forEach(Stock::updatePrice);
        System.out.println("\nAfter BearStrategy:");
        market.getStocks().forEach(System.out::println);

        System.out.println("\nSwitching to BullStrategy");
        market.getStocks().forEach(stock -> stock.setPricingStrategy(new BullMarketStrategy()));

        market.getStocks().forEach(Stock::updatePrice);
        System.out.println("\nAfter BullStrategy:");
        market.getStocks().forEach(System.out::println);
    }
}

