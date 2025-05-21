
public class Fruit {

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";


    private String name;
    private double weight;
    private double price;
    private double totalPrice;

    public Fruit(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.totalPrice = weight * price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return YELLOW + name + RESET + " (" + weight + " kg, " + price + " $/kg)";
    }
}
