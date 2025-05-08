
// A representative of the Mammal class
public class Lion extends Mammal{

    // The constructor which uses the Parent class constructor
    public Lion(String name, int age) {
        super(name, age);
    }

    // The specific makeSound()
    @Override
    public void makeSound() {
        System.out.println("rwaarrrr");
    }
}
