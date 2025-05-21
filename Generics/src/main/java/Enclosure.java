
import java.util.ArrayList;
import java.util.List;

// The generic class,
// 'T extends Animal' means that will expect to get instances of Animal class
public class Enclosure <T extends Animal> {
    private final List<T> animalList;

    // The constructor that initializes the animalList
    public Enclosure() {
        this.animalList = new ArrayList<>();
    }

    // The method that adds an animal and also prints out the instance of the class
    void addAnimal(T animal){
        animalList.add(animal);
        System.out.println("Added a new " + animal.getClass().getName()  + " : " + animal.getName());
    }

    // Making all the sound of the animal in the list
    void makeSounds() {
        for (T t : animalList) {
            t.makeSound();
        }
    }

    // Shows all the animals in the list
    void getAllAnimals() {
        animalList.forEach(System.out::println);
    }
}
