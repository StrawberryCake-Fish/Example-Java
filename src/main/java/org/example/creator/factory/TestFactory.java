package org.example.creator.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestFactory {
    private final static Logger logger = LoggerFactory.getLogger(TestFactory.class);

    private final DessertFactory americanDessert = new AmericanDessertFactory();

    private final DessertFactory italyDessert = new ItalyDessertFactory();

    @Test
    public void createAmericanDessert() {
        Coffee coffee = americanDessert.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        logger.info(coffee.getName());
        Dessert dessert = americanDessert.createDessert();
        dessert.show();
    }

    @Test
    public void createItalyDessert() {
        Coffee coffee = italyDessert.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        logger.info(coffee.getName());
        Dessert dessert = italyDessert.createDessert();
        dessert.show();
    }
}
