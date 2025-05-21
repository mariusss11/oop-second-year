package org.example.model;

import lombok.NoArgsConstructor;

public class Documents extends Load{

    public Documents(String details, Double weight) {
        super(details, weight);
    }

    public Documents(Double weight) {
        super("Private Documents", weight);
    }





    @Override
    public String toString() {
        return "Documents{" +
                "details='" + getDetails() + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
}
