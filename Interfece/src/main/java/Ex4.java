
interface Uninterruptible{
    void turnOn();
    void turnOff();
}

abstract class Device{

    int consumedPower;
    boolean status;

    public void turnOn(){
        status = true;
    }
    public void turnOff(){
        status = false;
    }

    public void showStatus(){
        System.out.print("The device is ");
        if (status)
            System.out.println("on");
        else
            System.out.println("off");
    }

    public void status(){
        if (status)
            System.out.println("on");
        else
            System.out.println("off");
    }

    public String getClassName(){
        return getClass().getName();
    }

    public abstract String toString();
}

abstract class Electronic extends Device{

}

class Fax extends Electronic{
    int transmissionRate;

    @Override
    public String toString(){
        return "The transmission rate of this fax is: " +  transmissionRate;
    }
}

class Computer extends Electronic {
    double frequency;
    double memory;


    @Override
    public String toString(){
        return "This computer has " +  memory + "GB of memory and " + frequency + "Hz of frequency";
    }


}

class Monitor extends Electronic implements Uninterruptible{
    double diagonal;

    @Override
    public String toString(){
        return "The monitor has a " + diagonal + " Inch display";
    }
}

class Radio extends Electronic implements Uninterruptible{
    String brand;

    @Override
    public String toString(){
        return "This is a " + brand + " radio";
    }
}

abstract class Electric extends Device{

}

class LightBulb extends Electric{

    @Override
    public String toString() {
        return "This light bulb is very powerful";
    }
}

class Radiator extends Electric{
    @Override
    public String toString() {
        return "This radiator is very warm";
    }
}

public class Ex4 {

    public static void allOn(Device[] devices){
        System.out.println("Morning routine");
        for (Device i : devices)
            i.turnOn();
    }

    public static void showAllStatus(Device[] devices){
        System.out.println("Showing the status");
        for (Device i : devices){
            System.out.print(i.getClassName() + " Status : ");
            i.status();
        }
    }

    public static void allOff(Device[] devices) {
        System.out.println("Evening routine");
        for (Device i : devices)
            i.turnOff();
    }


    public static void main(String[] args) {

        Fax fax = new Fax();
        Computer computer = new Computer();
        Monitor monitor = new Monitor();
        Radio radio = new Radio();
        LightBulb lightBulb = new LightBulb();
        Radiator radiator = new Radiator();

        Device[] devices = { fax, computer, monitor, radio, lightBulb, radiator };

        System.out.println();
        allOn(devices);
        showAllStatus(devices);
        System.out.println();

        allOff(devices);
        showAllStatus(devices);

        System.out.println();
        allOn(devices);
        showAllStatus(devices);
    }
}