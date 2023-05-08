import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> items;

    public Catalog() {
        items = new ArrayList<>();
    }

    public void loadItems() {

        items.add(new Item("Dairy Milk", "1", Category.CHOCOLATE, "Milk chocolate", "Cadbury", 20, 50, 0, 100));
        items.add(new Item("KitKat", "2", Category.CHOCOLATE, "Milk chocolate", "Nestle", 20, 50, 0, 100));
        //toffee
        items.add(new Item("Eclairs", "3", Category.TOFFEE, "Caramel", "Cadbury", 1, 10, 0, 100));
        //candy
        items.add(new Item("Mango Bite", "5", Category.CANDY, "Mango", "Parle", 1, 10, 0, 100));
        items.add(new Item("Coffee Bite", "6", Category.CANDY, "Coffee", "Parle", 1, 10, 0, 100));
    }

    public void displayItems() {
        this.loadItems();
        System.out.println("Catalog:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s\n", "Name", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        for (Item item : items) {
            System.out.printf("%-20s%-15.2f%-15d\n", item.getName(), item.getPrice(), item.getQuantity());
        }
        System.out.println("--------------------------------------------------");
    }


    public Item search(String id) {
            for (Item item : items) {
                if (item.getId().equals(id)) {
                    return item;
                }
            }
            return null;
    }



}
