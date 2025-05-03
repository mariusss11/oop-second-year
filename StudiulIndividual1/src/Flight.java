import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String planeNumber;
    private String startingPoint;
    private String arrivalPoint;
    private LocalTime takeoffTime;
    private LocalDate takeoffDate;
    private String pilotFirstName;
    private String pilotLastName;
    private int numberOfTickets;

    public Flight(
            String flightNumber,
            String planeNumber,
            String startingPoint,
            String arrivalPoint,
            LocalTime takeoffTime,
            LocalDate takeoffDate,
            String pilotFirstName,
            String pilotLastName,
            int numberOfTickets) {
        this.flightNumber = flightNumber;
        this.planeNumber = planeNumber;
        this.startingPoint = startingPoint;
        this.arrivalPoint = arrivalPoint;
        this.takeoffTime = takeoffTime;
        this.takeoffDate = takeoffDate;
        this.pilotFirstName = pilotFirstName;
        this.pilotLastName = pilotLastName;
        this.numberOfTickets = numberOfTickets;
    }



    @Override
    public String toString() {
        return "Flight{" +
                ", startingPoint='" + startingPoint + '\'' +
                ", arrivalPoint='" + arrivalPoint + '\'' +
                ", takeoffTime=" + takeoffTime +
                ", takeoffDate=" + takeoffDate +
                ", pilotFirstName='" + pilotFirstName + '\'' +
                ", pilotLastName='" + pilotLastName + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public String getPilotLastName() {
        return pilotLastName;
    }

    public String getPilotFirstName() {
        return pilotFirstName;
    }

    public LocalDate getTakeoffDate() {
        return takeoffDate;
    }

    public LocalTime getTakeoffTime() {
        return takeoffTime;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}
