import java.time.DayOfWeek;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class TravelAgency{

    String name;
    List<Plane> planes = new ArrayList<>()  ;
    List<Flight> flights = new ArrayList<>();

    public TravelAgency(String name){
        this.name = name;
    }

    public void addPlane(Plane plane){
        System.out.println(name + " just got a new plane: \n" + plane);
        planes.add(plane);
    }

    public void addFlight(Flight flight){
        System.out.println(name + " just got a new flight: \n" + flight);
        System.out.println("The date of the plane: " + flight.getTakeoffDate().getDayOfWeek());
        flights.add(flight);
    }

    public void showPlanes(){
        System.out.println("The list of planes owned by " + name);
        for (Plane plane : planes)
            System.out.println(plane);
    }

    public void showFlights(){
        System.out.println("The list of flights owned by " + name);
        for (Flight flight : flights)
            System.out.println(flight);
    }

    public void showFlightsByArrivalPoint(String arrivalPoint) {
        System.out.println("Flights that have the arrival point: " + arrivalPoint);
        flights.stream()
                .filter(flight -> flight.getArrivalPoint().equalsIgnoreCase(arrivalPoint))
                .forEach(System.out::println);
    }

    public List<Flight> showFlightsByWeekDay(String day) {
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
        System.out.println("Flights that fly on: " + day);
        return flights.stream()
                .filter(flight -> flight.getTakeoffDate().getDayOfWeek() == dayOfWeek)
                .toList();
    }

    public Flight theMostBoughtFlight() {
        System.out.println("The most bought fly");
        Flight searchFlight = null;
        int maximumTickets = 0;
        for (Flight flight : flights) {
            if (flight.getNumberOfTickets() > maximumTickets) {
                maximumTickets = flight.getNumberOfTickets();
                searchFlight = flight;
            }
        }
        return searchFlight;
    }


    public void getFlightByThePilotName(String firstName, String lastName) {
        // Verification of the pilot identity
        if (!verifyPilotIdentity(firstName, lastName)) {
            System.out.println("Invalid pilot with the name: " + firstName + " " + lastName);
            return;
        }

        System.out.println("Flights that have " + firstName + " " + lastName + " as the pilot");
        flights.stream()
                .filter(flight -> flight.getPilotFirstName().equalsIgnoreCase(firstName) &&
                        flight.getPilotLastName().equalsIgnoreCase(lastName))
                .forEach(System.out::println);
    }

    private boolean verifyPilotIdentity(String firstName, String lastName) {
        return planes.stream()
                .anyMatch(plane ->
                        plane.pilot.firstName.equalsIgnoreCase(firstName)
                                && plane.pilot.lastName.equalsIgnoreCase(lastName));
    }

}