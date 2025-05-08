public class Zoo {
    public static void main(String[] args) {


        Enclosure<Animal> enclosure = new Enclosure<>();

        Lion lion = new Lion("Simba", 1);
        Parrot  parrot = new Parrot("Johnny", 2);

        enclosure.addAnimal(lion);
        enclosure.addAnimal(parrot);

        enclosure.getAllAnimals();

        enclosure.makeSounds();
    }
}
