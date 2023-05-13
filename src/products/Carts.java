package products;
import orders.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Carts.
 */
public class Carts {
    /**
     * The Cat.
     */
    Catalog cat =null;
    private static List<Item> items;

    /**
     * The Order.
     */
    Orders order = new Orders();

    /**
     * Instantiates a new Carts.
     *
     * @param cata the cata
     */
    public Carts(Catalog cata){
        this.cat = cata;
        items = new ArrayList<>();
    }

    /**
     * Add to cart.
     *
     * @param name     the name
     * @param quantity the quantity
     */
    public void addToCart(String name, int quantity) {
        for (Item item : cat.getItems()) {
            if (item.getName().equals(name)) {
                if (item.getQuantity() >= quantity&&quantity>0) {
                    item.setQuantity(item.getQuantity() - quantity);
                    items.add(new Item(item.getName(), item.getId(), item.getCategory(), item.getDescription(), item.getBrand(), item.getPrice(), item.getWeight(), item.getDiscountPercentage(), quantity));
                    break;
                } else {
                    System.out.println("Quantity not available.");
                }
            }
        }
    }

    /**
     * Display cart.
     */
    public void displayCart() {
        System.out.println("Items in Cart:");
        System.out.println("----------------------------------");
        System.out.printf("%-20s%-15s\n", "Name", "Quantity");
        System.out.println("----------------------------------");
        for (Item item : items) {
            System.out.printf("%-20s%-15s\n",item.getName(), item.getQuantity());
        }
        System.out.println("----------------------------------");
        System.out.printf("%-20s%-15s\n", "Total Price->", getTotalPrice());
        System.out.println("----------------------------------");
    }

    /**
     * Remove from cart.
     *
     * @param name the name
     */
    public void removeFromCart(String name) {// remove from cart as a button beside the item
        for (Item item : items) {
            if (item.getName().equals(name)) {
                items.remove(item);
                break;
            }

        }
        for (Item item : cat.getItems()) {
            if (item.getName().equals(name)) {
                item.setQuantity(item.getQuantity() + 1);
                break;
            }
        }
        System.out.println("Item removed from cart");
    }

    /**
     * Clear cart.
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public static double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    /**
     * Gets total weight.
     *
     * @return the total weight
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight() * item.getQuantity();
        }
        return totalWeight;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public static List<Item> getorderItems() {
        return items;
    }

    /**
     * Gets total quantity.
     *
     * @return the total quantity
     */
    public static int getTotalQuantity() {
        int totalQuantity = 0;
        for (Item item : items) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }



}
