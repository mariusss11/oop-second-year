
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Shop {

    private static final Customer customer = new Customer();
    private static final Scanner scanner = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {

        // Test code
        customer.getFruitList().add(new Fruit("Banana", 2, 15));
        customer.getFruitList().add(new Fruit("Apple", 1, 10));
        customer.getFruitList().add(new Fruit("Pear", 2, 15));
        customer.getFruitList().add(new Fruit("Strawberry", 2, 15));
        customer.getFruitList().add(new Fruit("Blueberry", 2, 15));

        System.out.println(BOLD + CYAN + "WELCOME TO YOUR FAVORITE SHOP!" + RESET);
        configCustomer();
        showMenu();

    }

    private static void configCustomer() {
        System.out.print(YELLOW + "Enter your name: " + RESET);
        String name = scanner.nextLine();
        customer.setName(name);
        System.out.println(GREEN + "Welcome, " + name + "!" + RESET);
    }

    public static void showMenu() {
        int option;
        do {
            System.out.println(BLUE + "\n=== MENU ===" + RESET);
            System.out.println("1. " + GREEN + "Add a product" + RESET);
            System.out.println("2. " + RED + "Remove a product" + RESET);
            System.out.println("3. " + YELLOW + "See product list" + RESET);
            System.out.println("4. " + YELLOW + "See product list sorted by weight" + RESET);
            System.out.println("5. " + YELLOW + "See product list between some prices" + RESET);
            System.out.println("6. " + PURPLE + "Pay (Checkout)" + RESET);
            System.out.println("7. " + CYAN + "Exit the shop" + RESET);
            System.out.print("Enter your option: ");

            while (!scanner.hasNextInt()) {
                System.out.print(RED + "Please enter a valid number: " + RESET);
                scanner.next();
            }

            option = scanner.nextInt();

            switch (option) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> showProductList();
                case 4 -> showListSortedByWeight();
                case 5 -> findProductsBetweenSomePrices();
                case 6 -> showCheckout();
                case 7 -> System.out.println(CYAN + "Goodbye, have a nice day!" + RESET);
                default -> System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
        } while (option < 6);
    }

    private static void addProduct() {
        scanner.nextLine();
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the product weight (kg): ");
        double weight = getDoubleInput();
        System.out.print("Enter the product price ($/kg): ");
        double price = getDoubleInput();

        customer.addFruit(new Fruit(name, weight, price));
    }

    private static void removeProduct() {
        scanner.nextLine();
        List<Fruit> productList = customer.getFruitList();
        if (!productList.isEmpty()) {
            productList.forEach(fruit -> System.out.println(" - " + fruit));
            System.out.print("Enter the product name to remove: ");
            String name = scanner.nextLine();
            try {
                Fruit fruitToRemove = customer.getFruitList().stream()
                        .filter(fruit -> fruit.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("No product with this name: " + name));
                customer.removeFruit(fruitToRemove);
            } catch (RuntimeException e) {
                System.out.println(RED + e.getMessage() + RESET);
            }
        }
    }

    private static List<Fruit> getProductList() {
        List<Fruit> productList = customer.getFruitList();
        if (productList.isEmpty()) {
            System.out.println(RED + "The product list is empty." + RESET);
        }
        return productList;
    }

    private static void showProductList() {
        List<Fruit> productList = getProductList();

        if (!productList.isEmpty()) {
            System.out.println(BLUE + "Your product list:" + RESET);
            productList.forEach(fruit -> System.out.println(" - " + fruit));
        }

    }

    private static void showCheckout() {
        System.out.println();
        customer.returnTheCheckout();
    }

    private static void showListSortedByWeight() {
        List<Fruit> fruitList = getProductList();
        if (!fruitList.isEmpty()) {
            List<Fruit> fruitListSortedByWeight = fruitList.stream()
                    .sorted(Comparator.comparingDouble(Fruit::getWeight))
                    .toList();
            System.out.println(BLUE + "Your product list sorted by weight:" + RESET);
            fruitListSortedByWeight.forEach(fruit -> System.out.println(" - " + fruit));
        }

    }

    private static void findProductsBetweenSomePrices() {
        List<Fruit> fruitList = getProductList();
        if (!fruitList.isEmpty()) {
            System.out.print("Enter the first price: ");
            int firstPrice = scanner.nextInt();
            System.out.print("Enter the second price: ");
            int secondPrice = scanner.nextInt();
            scanner.nextLine();
            if (firstPrice > secondPrice) {
                int temp = firstPrice;
                firstPrice = secondPrice;
                secondPrice = temp;
            }

            int finalSecondPrice = secondPrice;
            int finalFirstPrice = firstPrice;
            List<Fruit> fruitListBetweenSpecificPrice = getProductList().stream()
                    .filter(fruit -> fruit.getPrice() >= finalFirstPrice && fruit.getPrice() < finalSecondPrice)
                    .toList();

            if (!fruitListBetweenSpecificPrice.isEmpty()) {
                System.out.println(BLUE + "Your product list between " + finalFirstPrice + " $ -> " + finalSecondPrice + " $ " + RESET);
                fruitListBetweenSpecificPrice.forEach(fruit -> System.out.println(" - " + fruit));
            } else {
                System.out.println(RED + "There are no products between  " + finalFirstPrice + " $ -> " + finalSecondPrice + " $ " + RESET);
            }
        }

    }

    private static double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print(RED + "Please enter a valid number: " + RESET);
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
