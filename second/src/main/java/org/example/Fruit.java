package org.example;

public class Fruit {
    private String name;
    private double weight;
    private double price;
    private double totalPrice;

    public Fruit(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.totalPrice = weight * price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return Shop.YELLOW + name + Shop.RESET + " (" + weight + " kg, " + price + " $/kg)";
    }
}
