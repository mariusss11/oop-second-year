import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

class Main {

    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the travel agency
        TravelAgency WizzAir = new TravelAgency("WizzAir");

        // Create the plane
        Plane plane1 = new Plane(UUID.randomUUID().toString(),"Boeing", 15, Plane.TimeOfWorking.Day, 4);

        // Add the plane to the travel agency
        WizzAir.addPlane(plane1);

        // Showing all the planes of the travel agency
        WizzAir.showPlanes();

        // Adding a pilot to the plane
        plane1.addPilot(new Pilot("Ramon", "Balan"));

        // Creating some persons
        Passenger person1 = new Passenger("Dumitru");
        Passenger person2 = new Passenger("Stas");

        // Adding previous created persons to the board of the plane
        plane1.addPassenger(person1);
        plane1.addPassenger(person2);

        // Showing the passengers of the plane
        plane1.showPassenger();

        // Creating the flight
        Flight flight1 = new Flight(
                UUID.randomUUID().toString(),
                plane1.planeNumber,
                "Chisinau",
                "Bucharest",
                LocalTime.now(),
                LocalDate.now(),
                plane1.pilot.firstName,
                plane1.pilot.lastName,
                plane1.passengers.size()
        );

        // Adding the flight in the travel agency
        WizzAir.addFlight(flight1);



        // MORE EXAMPLES

        Plane plane2 = new Plane(UUID.randomUUID().toString(),"Falcon", 30, Plane.TimeOfWorking.Night, 5);
        plane2.addPilot(new Pilot("Alice", "Jordan"));
        WizzAir.addPlane(plane2);

        plane2.addPassenger(new Passenger("Robert"));
        plane2.addPassenger(new Passenger("Bogdan"));
        plane2.addPassenger(new Passenger("Victor"));
        plane2.addPassenger(new Passenger("Cristian"));
        plane2.addPassenger(new Passenger("Codrin"));
        plane2.addPassenger(new Passenger("Bogdan"));

        Flight flight2 = new Flight(UUID.randomUUID().toString(), plane2.planeNumber, "London", "Paris", LocalTime.of(10, 15), LocalDate.now(), plane2.pilot.firstName, plane2.pilot.lastName, plane2.passengers.size());
        WizzAir.addFlight(flight2);

        Plane plane3 = new Plane(UUID.randomUUID().toString(),"Falcon 900", 10, Plane.TimeOfWorking.Day, 3);
        plane3.addPilot(new Pilot("Michael", "Johnson"));
        WizzAir.addPlane(plane3);

        plane3.addPassenger(new Passenger("Dan"));
        plane3.addPassenger(new Passenger("Iura"));
        plane3.addPassenger(new Passenger("Sebastian"));

        Flight flight3 = new Flight(UUID.randomUUID().toString(), plane3.planeNumber, "New York", "Los Angeles", LocalTime.of(14, 45), LocalDate.now(), plane3.pilot.firstName, plane3.pilot.lastName, plane3.passengers.size());

        WizzAir.addFlight(flight3);


        Plane plane4 = new Plane(UUID.randomUUID().toString(),"Airbus A320", 25, Plane.TimeOfWorking.Night, 2);
        plane4.addPilot(new Pilot("John", "Petty"));
        WizzAir.addPlane(plane4);


        plane4.addPassenger(new Passenger("Cristian"));
        plane4.addPassenger(new Passenger("Bogdan"));
        plane4.addPassenger(new Passenger("Alexandr"));

        Flight flight4 = new Flight(UUID.randomUUID().toString(), plane1.planeNumber, "Turkey", "Bucharest", LocalTime.of(8, 30), LocalDate.now(), plane1.pilot.firstName, plane1.pilot.lastName, plane1.passengers.size());

        WizzAir.addFlight(flight4);

        clear();

        WizzAir.showFlights();

        // Menu Loop
        while (true) {
            clear();
            System.out.println("Welcome to WizzAir Travel Agency");
            System.out.println("1. Show all flights");
            System.out.println("2. Show flights by arrival point");
            System.out.println("3. Show flights by weekday");
            System.out.println("4. Show the most bought flight");
            System.out.println("5. Get flight by pilot's name");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    WizzAir.showFlights();
                    break;
                case 2:
                    System.out.print("Enter the arrival point (e.g., Bucharest): ");
                    String arrivalPoint = scanner.nextLine();
                    WizzAir.showFlightsByArrivalPoint(arrivalPoint);
                    break;
                case 3:
                    System.out.print("Enter the weekday (e.g., MONDAY, TUESDAY): ");
                    String day = scanner.nextLine();
                    System.out.println(WizzAir.showFlightsByWeekDay(day));
                    break;
                case 4:
                    System.out.println(WizzAir.theMostBoughtFlight());
                    break;
                case 5:
                    System.out.print("Enter the pilot's first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter the pilot's last name: ");
                    String lastName = scanner.nextLine();
                    WizzAir.getFlightByThePilotName(firstName, lastName);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option, please try again.");
            }

            // Pause to let user read the output
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }

    }
}
