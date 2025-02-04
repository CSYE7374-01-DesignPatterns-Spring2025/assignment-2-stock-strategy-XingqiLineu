package edu.neu.csye7374;

public class TechnologyStockFactoryLazySingleton implements StockFactory {
    private static TechnologyStockFactoryLazySingleton instance;

    private TechnologyStockFactoryLazySingleton() {
    }

    public static TechnologyStockFactoryLazySingleton getInstance() {
        if (instance == null) {
            instance = new TechnologyStockFactoryLazySingleton();
        }
        return instance;
    }

    @Override
    public Stock createStock(String name, double price, String description) {
        return new TechnologyStock(name, price, description);
    }
}
