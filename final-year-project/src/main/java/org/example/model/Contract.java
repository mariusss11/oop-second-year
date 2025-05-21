package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Contract {

    private Route route;
    private LocalDateTime departureDate;
    private LocalDateTime arriveDate;
    private Client sender;
    private Client recipient;
    private Driver driver;
    private double pricePerKm;
    private double totalPrice;
    private List<Load> loadList;

    public Contract(
            Route route,
            LocalDateTime departureDate,
            LocalDateTime arriveDate,
            Client sender,
            Driver driver
    ) {
        this.route = route;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.sender = sender;
        this.driver = driver;
        setPricePerKm();
        this.loadList = new ArrayList<>();
    }

    public Contract() {
        this.loadList = new ArrayList<>();
        this.departureDate = LocalDate.now().atStartOfDay();
    }

    public void setPricePerKm() {
        if (route.getDistance() <= 200)
            pricePerKm = 0.5;
        else if (route.getDistance() <= 500)
            pricePerKm = 1.0;
        else
            pricePerKm = 2;
    }

    public void addLoad(Load load) {
        loadList.add(load);
    }

    public void printLoads() {
        loadList.forEach(System.out::println);
    }

    public void calculateTotalPrice() {
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String CYAN = "\u001B[36m";
        final String BOLD = "\033[1m";

        System.out.println(BOLD + GREEN + "Your checkout is: " + RESET);
        double totalPrice = 0.0;
        for (Load load : loadList) {
            double loadPrice = getPricePerLoadWeight(load.getWeight());
            totalPrice += loadPrice;
            System.out.println(YELLOW + load.getDetails() + " : " + loadPrice + RESET);
        }

        double deliveryPrice = getDriverSalary();
        totalPrice += deliveryPrice;

        System.out.println(CYAN + "Delivery Price: " + deliveryPrice + RESET);
        System.out.println(BOLD + GREEN + "The total price is: " + totalPrice + RESET);
    }


    private Double getPricePerLoadWeight(Double weight) {
        if (!route.isInternational())
            return weight + 10;

        if (weight <= 50)
            return 500.0;
        else if (weight <= 100) {
            return 1000.00;
        } else if (weight <= 150) {
            return 3000.00;
        } else if (weight <= 200)
            return 3500.00;
        else
            return 4000.0;
    }

    private Double getDriverSalary() {
        double distance = route.getDistance();
        double driverSalary = 0.0;

        double driverPayment = distance * driver.getSalaryPerKm();
//        System.out.println("Driver Payment: " + driverPayment);
        driverSalary += driverPayment;

        double fuelCost = (distance * 0.065) * 22;
//        System.out.println("FuelCost: " + fuelCost);

        if (route.isInternational())
            driverSalary += driverSalary * 0.1;

        driverSalary += fuelCost;
//        System.out.println("DriverSalary: " + driverSalary);
        return driverSalary;
    }

    public void calculateArriveDate() {
        long daysToArrive = (long) (route.getDistance() / 650.0);
        arriveDate = departureDate.plusDays(daysToArrive);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "route=" + route +
                ", departureDate=" + departureDate +
                ", arriveDate=" + arriveDate +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", driver=" + driver +
                ", pricePerKm=" + pricePerKm +
                ", totalPrice=" + totalPrice +
                ", loadList=" + loadList +
                '}';
    }
}
