package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Load {

    private String details;
    private Double weight;

    public Load(String details, Double weight) {
        this.details = details;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Load{" +
                "details='" + details + '\'' +
                ", weight=" + weight +
                '}';
    }
}
