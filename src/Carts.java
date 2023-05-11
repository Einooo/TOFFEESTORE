import java.util.ArrayList;
import java.util.List;

public class Carts {
    Catalog cat =null;
    private static List<Item> items;

    Orders order = new Orders();
    public Carts(Catalog cata){
        this.cat = cata;
        items = new ArrayList<>();
    }

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

    public void clearCart() {
        items.clear();
    }

    public static double getTotalPrice() {
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

//    public void checkout() {
//        System.out.println("Items in Cart:");
//        System.out.println("----------------------------------");
//        System.out.printf("%-20s%-15s%-15s%-15s\n", "Name", "Quantity", "Price", "Weight");
//        System.out.println("----------------------------------");
//        for (Item item : items) {
//            System.out.printf("%-20s%-15s%-15s%-15s\n", item.getName(), item.getQuantity(), item.getPrice(), item.getWeight());
//        }
//        System.out.println("----------------------------------");
//        System.out.printf("%-20s%-15s\n", "Total Price->", getTotalPrice());
//        System.out.printf("%-20s%-15s\n", "Total Weight->", getTotalWeight());
//        System.out.println("----------------------------------");
//        clearCart();
//    }
public static List<Item> getorderItems() {
    return items;
}




}
