import java.util.ArrayList;
import java.util.List;

class Plane{

    String planeNumber;
    String nameOfThePlane;
    int numOfPlaces;
    int consumePer100km;
    TimeOfWorking time;

    enum TimeOfWorking{
        Day, Midday, Night, Midnight
    }

    Pilot pilot;

    List<Passenger> passengers;

    public Plane(String planeNumber, String nameOfThePlane, int numOfPlaces, TimeOfWorking time, int consumePer100km){
        this.planeNumber = planeNumber;
        this.nameOfThePlane = nameOfThePlane;
        this.numOfPlaces = numOfPlaces;
        this.time = time;
        this.consumePer100km = consumePer100km;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
        System.out.println("Added " + passenger.name + " to the board of the: " + this.nameOfThePlane);
    }

    public void addPilot(Pilot pilot){
        this.pilot = pilot;
        System.out.println("Added " + pilot.firstName + " as the pilot of: " + this.nameOfThePlane);
    }

    public void showPassenger(){
        System.out.println("The list of passengers on the " + nameOfThePlane);
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
    }

    @Override
    public String toString(){
        return "Plane number: " + planeNumber + ", Name of the plane: " + nameOfThePlane + ", Number of seats: " + numOfPlaces + ", Working time " + time;
    }

}