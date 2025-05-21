package org.example;

import org.example.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BOLD = "\033[1m";

    public static Scanner scanner = new Scanner(System.in);
    public static List<Route> routeList = new ArrayList<>();
    public static Contract contract = new Contract();

    public static void main(String[] args) {


        Client client1 = new Client("Carchilan Darius", "str. Alexandru cel Bun", "061234567");

        Driver driver1 = new Driver("Gigu", LocalDate.of(2024, 1, 1));


        Route route1 = new Route("Chisinau", "Bucharest", 500.0, true);
        Route route2 = new Route("Chisinau", "Kiev", 670.0, true);
        Route route3 = new Route("Chisinau", "Madrid", 3600.0, true);

        routeList.add(route1);
        routeList.add(route2);
        routeList.add(route3);



        clearScreen();
        System.out.println(GREEN + "Hello " + client1.getName() + "! Welcome to Hamali Company" + RESET);
        contract.setSender(client1);
        contract.setDriver(driver1);
        while (true) {
//            System.out.println(BOLD + CYAN + "Contract: " + RESET + contract);
            System.out.println(BLUE + "0. Exit" + RESET);
            System.out.println(BLUE + "1. Add a load" + RESET);
            System.out.println(BLUE + "2. Remove a load" + RESET);
            System.out.println(BLUE + "3. See all load you have" + RESET);
            System.out.println(BLUE + "4. Configure a route" + RESET);
            System.out.println(BLUE + "5. Configure the recipient" + RESET);
            System.out.println(BLUE + "6. Make delivery" + RESET);
            System.out.print(YELLOW + "Option: " + RESET);
            int option = scanner.nextInt();
            scanner.nextLine();
            clearScreen();

            if (option == 0)
                break;

            switch (option) {
                case 1 -> addLoad();
                case 2 -> removeLoad();
                case 3 -> printLoads();
                case 4 -> configureRoute();
                case 5 -> configureRecipient();
                case 6 -> confirmDelivery();
                default -> System.out.println(RED + "Invalid option. Please choose a valid one!" + RESET);

            }

        }
    }

    private static void confirmDelivery() {
        if (contract.getRoute() == null) {
            System.out.println(RED + "Please configure the route" + RESET);
            configureRoute();
        }
        contract.calculateArriveDate();

        if (getLoads().isEmpty()) {
            clearScreen();
            System.out.println(RED + "Please add some loads" + RESET);
            addLoad();
        }

        if (contract.getRecipient() == null) {
            System.out.println("Please configure the recipient");
            configureRecipient();
        }

        clearScreen();
        System.out.println(GREEN + BOLD + "Your contract is ready" + RESET);
        System.out.println(CYAN + "Please re-check the info:" + RESET);
        System.out.println("Sender Name: " + contract.getSender().getName());
        System.out.println("Sender Address: " + contract.getSender().getAddress());
        System.out.println("Sender Phone Number: " + contract.getSender().getPhoneNumber());
        System.out.println("Recipient Name: " + contract.getRecipient().getName());
        System.out.println("Recipient Address: " + contract.getRecipient().getAddress());
        System.out.println("Recipient Phone Number: " + contract.getRecipient().getPhoneNumber());
        System.out.println("Route: " + contract.getRoute());
        System.out.println("The list of loads:");
        printLoads();

        if (!confirmAction()) {
            return;
        } else
            clearScreen();

        contract.calculateTotalPrice();
    }



    private static void configureRecipient() {
        while (true) {

            String recipientName = requestString("recipient name");

            System.out.print(YELLOW + "Enter recipient address: " + RESET);
            String recipientAddress = scanner.nextLine();

            System.out.print(YELLOW + "Enter recipient phone number: " + RESET);
            String recipientPhoneNumber = scanner.nextLine();

            Client recipient = new Client(recipientName, recipientAddress, recipientPhoneNumber);
            System.out.println(CYAN + "Recipient: " + recipient + RESET);

            if (confirmAction()) {
                contract.setRecipient(recipient);
                break;
            }
        }
    }


    private static void configureRoute() {
        while (true) {
            routeList.forEach(System.out::println);
            int route = requestInteger("route");
            Route chosenRoute = null;
            try {
                chosenRoute = routeList.get(route - 1);
                System.out.println("Your route is : " + chosenRoute);
                if (confirmAction()) {
                    System.out.println(GREEN + "The route is confirmed" + RESET);
                    contract.setRoute(chosenRoute);
                    break;
                }
            } catch (Exception e) {
                clearScreen();
                System.out.println(RED + "Invalid option. Please choose a valid one!" + RESET);
            }
        }
    }

    public static void addLoad() {
        while (true) {
            System.out.println(YELLOW + "What type of load you want to add?" + RESET);
            System.out.println("0. Exit");
            System.out.println("1. Documents");
            System.out.println("2. Cargo");
            System.out.print(YELLOW + "Option: " + RESET);
            String option = scanner.nextLine();

            switch (option) {
                case "0" -> {
                    clearScreen();
                    return;
                }
                case "1" -> {
                    if (handleAddLoad("Documents")) return;
                }
                case "2" -> {
                    if (handleAddLoad("Cargo")) return;
                }
                default -> {
                    System.out.println(RED + "Invalid option. Please choose a valid one!" + RESET);
                }
            }
        }
    }


    private static boolean handleAddLoad(String type) {
        double weight = requestDouble(type.toLowerCase() + " weight (kg)");

        System.out.print(YELLOW + type + " details: " + RESET);
        String details = scanner.nextLine();

        Load loadToAdd = switch (type) {
            case "Documents" -> new Documents(details, weight);
            case "Cargo" -> new Cargo(details, weight);
            default -> throw new RuntimeException("Invalid datatype");
        };

        System.out.println(CYAN + "Your load is: " + loadToAdd + RESET);
        if (confirmAction()) {
            System.out.println(GREEN + "The " + type.toLowerCase() + " is added" + RESET);
            contract.addLoad(loadToAdd);
            clearScreen();
            return true;
        }
        return false;
    }

    public static void removeLoad() {
        List<Load> loadList = getLoads();
        if (loadList.isEmpty()) {
            System.out.println(RED + "There are no loads!" + RESET);
        } else {
            while (true) {
                System.out.println("The list of the currents loads: ");
                for (int i = 0; i < loadList.size(); i++) {
                    System.out.println((i + 1) + ". " + loadList.get(i).getDetails());
                }
                Load loadToRemove = null;
                try {
                    int option = requestInteger("the id of the load you want to remove (0 to exit)");

                    if (option == 0)
                        break;

                    loadToRemove = loadList.get(option - 1);
                    System.out.println(CYAN + "Load to remove: " + loadToRemove + RESET);

                    if (confirmAction()) {
                        System.out.println(GREEN + "The load will be removed" + RESET);
                        loadList.remove(option - 1);
                        clearScreen();
                        break;
                    }
                    clearScreen();
                } catch (Exception e) {
                    System.out.println(RED + "Invalid option. Please choose a valid one!" + RESET);
                }
            }
        }
    }

    private static String requestString(String requestedVariable) {
        System.out.print(YELLOW + "Enter " + requestedVariable + ": " + RESET);
        while (true) {
            String variable = scanner.nextLine();
            if (variable.chars().anyMatch(Character::isDigit)) {
                System.out.print(RED + "Invalid " + requestedVariable + YELLOW + ". Re-enter a valid one: " + RESET);
            } else
                return variable;
        }
    }

    private static Double requestDouble(String requestedVariable) {
        System.out.print(YELLOW + "Enter " + requestedVariable  + ": " + RESET );
        while (true) {
            double weight = 0.0;
            try {
                weight = scanner.nextDouble();
                scanner.nextLine();
                return weight;
            } catch (Exception e) {
                System.out.print(RED + "Invalid " + requestedVariable + YELLOW + ". Re-enter a valid one: " + RESET);
            }
            scanner.nextLine();
        }
    }

    private static Integer requestInteger(String requestedVariable) {
        System.out.print(YELLOW + "Enter " + requestedVariable + ": " + RESET);
        while (true) {
            int variable = 0;
            try {
                variable = scanner.nextInt();
                scanner.nextLine();
                clearScreen();
                return variable;
            } catch (Exception e) {
                System.out.print(RED + "Invalid value!" + YELLOW + " Re-enter a valid one: " + RESET);
            }
            scanner.nextLine();
        }
    }

    public static void printLoads() {
        List<Load> loadList = getLoads();
        if (loadList.isEmpty())
            System.out.println(RED + "There are no loads!" + RESET);
        else
            contract.printLoads();
    }

    public static List<Load> getLoads() {
        return contract.getLoadList();
    }

    private static boolean confirmAction() {
        System.out.print(YELLOW + "Confirm (y/n): " + RESET);
        String confirmation = scanner.nextLine();
        return confirmation.equalsIgnoreCase("y") || confirmation.isEmpty() ||String.valueOf(confirmation.charAt(0)).equalsIgnoreCase("y");
    }

    private static void clearScreen() {
        for (int i = 0; i <= 15 ; i++) {
            System.out.println();
        }
    }

}
