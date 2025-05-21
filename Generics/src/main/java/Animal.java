
// The general animal class
public abstract class Animal {
    private String name;
    private int age;

    // The method all the class will have
    public abstract void makeSound();

    // The basic constructor when initializing the Animal
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
