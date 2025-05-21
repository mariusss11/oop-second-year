
import org.example.Shop;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Fruit> fruitList;

    public Customer() {
        this.fruitList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFruit(Fruit fruit) {
        System.out.println(Shop.GREEN + fruit.getName() + " was added to the shopping list." + Shop.RESET);
        fruitList.add(fruit);
    }

    public void removeFruit(Fruit fruit) {
        fruitList.remove(fruit);
        System.out.println(Shop.RED + fruit.getName() + " was removed from the shopping list." + Shop.RESET);
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public double returnTotalPrice() {
        return fruitList.stream().mapToDouble(Fruit::getTotalPrice).sum();
    }

    public void returnTheCheckout() {
        System.out.println(Shop.BLUE + "====== CHECKOUT ======" + Shop.RESET);
        if (fruitList.isEmpty()) {
            System.out.println(Shop.RED + "No items in the cart!" + Shop.RESET);
            return;
        }
        for (Fruit fruit : fruitList) {
            System.out.println(
                    Shop.GREEN + fruit.getName() + Shop.RESET + " | " +
                            Shop.YELLOW + fruit.getWeight() + " kg" + Shop.RESET + " " +
                            Shop.CYAN + fruit.getPrice() + " $/kg" + Shop.RESET + " => " +
                            Shop.PURPLE + fruit.getTotalPrice() + " $" + Shop.RESET
            );
        }
        System.out.println(Shop.BOLD + Shop.RED + "TOTAL TO PAY: " + Shop.YELLOW + returnTotalPrice() + " $" + Shop.RESET);
    }
}
