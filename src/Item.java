import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private String id;
    private Category category;
    private String description;
    private String brand;
    private double price;
    private double weight;
    private double discountPercentage;
    private int quantity;

    public Item(String name, String id, Category category, String description, String brand, double price, double weight, double discountPercentage, int quantity) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.weight = weight;
        this.discountPercentage = discountPercentage;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public int getQuantity() {
        return quantity;
    }
}


