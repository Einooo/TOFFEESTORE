import java.util.ArrayList;
import java.util.List;

public class Carts {
    Catalog cat = new Catalog();
    private List<Item> items;

    public Carts() {
        items = new ArrayList<>();
    }

    public void addToCart(String name, int quantity) {
        for (Item item : cat.getItems()) {
            if (item.getName().equals(name)) {
                items.add(new Item(item.getName(), item.getId(), item.getCategory(), item.getDescription(), item.getBrand(), item.getPrice(), item.getWeight(), item.getDiscountPercentage(), quantity));
                break;
            }
        }
        for (Item item : cat.getItems()) {
            if (item.getName().equals(name)) {
                item.setQuantity(item.getQuantity() - quantity);
                break;
            }
        }
    }

    public void displayCart() {
        System.out.println("Items in Cart:");
        for (Item item : items) {
            System.out.println(item.getName() + " " + item.getQuantity());
        }
    }

    public void removeFromCart(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                items.remove(item);
                break;
            }
        }
    }

    public void clearCart() {
        items.clear();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight() * item.getQuantity();
        }
        return totalWeight;
    }
}
