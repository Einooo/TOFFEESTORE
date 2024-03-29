package products;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Catalog.
 */
public class Catalog {
    private List<Item> items;

    /**
     * Instantiates a new Catalog.
     */
    public Catalog() {
        items = new ArrayList<>();
        items.add(new Item("dairy_milk", "1", Category.CHOCOLATE, "Milk chocolate", "Cadbury", 20, 50, 0, 100));
        items.add(new Item("kitkat", "2", Category.CHOCOLATE, "Milk chocolate", "Nestle", 10, 50, 0, 100));
        //toffee
        items.add(new Item("eclairs", "3", Category.TOFFEE, "Caramel", "Cadbury", 15, 10, 0, 100));
        //candy
        items.add(new Item("mango_bite", "5", Category.CANDY, "Mango", "Parle", 17, 10, 0, 100));
        items.add(new Item("coffee_bite", "6", Category.CANDY, "Coffee", "Parle", 16, 10, 0, 100));
    }


    /**
     * Display items.
     */
    public void displayItems() {

        System.out.println("Catalog:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s\n", "Name", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        for (Item item : items) {
            System.out.printf("%-20s%-15s%-15s\n", item.getName(), item.getPrice(), item.getQuantity());
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Gets item.
     *
     * @param name the name
     * @return the item
     */
    public boolean getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Search boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public Boolean search(String name) {
        for (Item item : items) {
            if (getItem(name)) {
                System.out.println("Name: " + item.getName());
                System.out.println("Description: " + item.getDescription());
                System.out.println("Brand: " + item.getBrand());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Category: " + item.getCategory());
                System.out.println("Weight: " + item.getWeight());
                System.out.println("Quantity: " + item.getQuantity());
                return true;
            }
        }
        return false;
    }

    /**
     * Get items item [ ].
     *
     * @return the item [ ]
     */
    public Item[] getItems() {
        return items.toArray(new Item[items.size()]);
    }
}
