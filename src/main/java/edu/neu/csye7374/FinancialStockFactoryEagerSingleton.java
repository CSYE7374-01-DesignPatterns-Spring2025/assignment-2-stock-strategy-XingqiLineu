package edu.neu.csye7374;

public class FinancialStockFactoryEagerSingleton implements StockFactory {
    private static final FinancialStockFactoryEagerSingleton instance = new FinancialStockFactoryEagerSingleton();

    private FinancialStockFactoryEagerSingleton() {
    }

    public static FinancialStockFactoryEagerSingleton getInstance() {
        return instance;
    }

    @Override
    public Stock createStock(String name, double price, String description) {
        return new FinancialStock(name, price, description);
    }
}
