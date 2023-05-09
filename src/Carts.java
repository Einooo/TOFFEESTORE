import java.util.ArrayList;
import java.util.List;

public class Carts {
    Catalog cat = new Catalog();
    private List<Item> items;

    public Carts() {
        items = new ArrayList<>();
    }

    public void addToCart(String name, int quantity) {
        if (cat.search(name)) {
            Item item = cat.getItem(name);
            item.setQuantity(quantity);
            items.add(item);
            //change the quantity of the item in the catalog
            cat.getItem(name).setQuantity(cat.getItem(name).getQuantity() - quantity);
        } else {
            System.out.println("Item not found.");
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
