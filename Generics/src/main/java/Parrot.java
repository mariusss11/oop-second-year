
// A representative of the Bird class
public class Parrot extends Bird {

    // The constructor which uses the Parent class constructor
    public Parrot(String name, int age) {
        super(name, age);
    }

    // The specific makeSound()
    @Override
    public void makeSound() {
        System.out.println("parrot sound....");
    }
}
