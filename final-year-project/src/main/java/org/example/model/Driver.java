package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    private String name;
    private Double salary;
    private LocalDate dateOfEmployment;
    private Double salaryPerKm;

    public Driver(String name, LocalDate dateOfEmployment) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;

        long yearsEmployed = ChronoUnit.YEARS.between(dateOfEmployment, LocalDate.now());
        if (yearsEmployed < 3)
            salaryPerKm = 1.0;
        else salaryPerKm = 2.5;
    }
}
