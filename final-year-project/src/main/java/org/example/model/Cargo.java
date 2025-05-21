package org.example.model;

public class Cargo extends Load{

    public Cargo(String details, Double weight) {
        super(details, weight);
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "details='" + getDetails() + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
}
