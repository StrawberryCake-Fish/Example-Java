package org.example.creator.factory;

public class LatteCoffee implements Coffee {
    private String name = "LatteCoffee.";

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
