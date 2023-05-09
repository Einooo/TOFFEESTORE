import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Item> items;

    public Catalog() {
        items = new ArrayList<>();
    }

    public void loadItems() {

        items.add(new Item("dairy milk", "1", Category.CHOCOLATE, "Milk chocolate", "Cadbury", 20, 50, 0, 100));
        items.add(new Item("kitkat", "2", Category.CHOCOLATE, "Milk chocolate", "Nestle", 10, 50, 0, 100));
        //toffee
        items.add(new Item("eclairs", "3", Category.TOFFEE, "Caramel", "Cadbury", 15, 10, 0, 100));
        //candy
        items.add(new Item("mango bite", "5", Category.CANDY, "Mango", "Parle", 17, 10, 0, 100));
        items.add(new Item("coffee bite", "6", Category.CANDY, "Coffee", "Parle", 16, 10, 0, 100));
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


    public Boolean search(String name) {
        this.loadItems();
        for (Item item : items) {
            if (item.getName().equals(name)) {// print "Name", "Description", "Brand", "Price", "Category","Weight", "Quantity");
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
}
