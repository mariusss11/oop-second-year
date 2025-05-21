package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {

    private String name;
    private String senderCity;
    private String recipientCity;
    private Double distance;
    private boolean isInternational;

    public Route(String senderCity, String recipientCity, Double distance, boolean isInternational) {
        this.name = senderCity + " -> " + recipientCity;
        this.senderCity = senderCity;
        this.recipientCity = recipientCity;
        this.distance = distance;
        this.isInternational = isInternational;
    }

    @Override
    public String toString() {
        return "Route{" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
