public class Passenger {
   String name;

    public Passenger(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + name;
    }
}
