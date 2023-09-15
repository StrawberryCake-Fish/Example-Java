package org.example.creator.factory;

public class AmericanCoffee implements Coffee {
    private String name = "AmericanCoffee.";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addMilk() {
        name = name + ".Milk.";
    }

    @Override
    public void addSugar() {
        name = name + ".Sugar.";
    }
}
