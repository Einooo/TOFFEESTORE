package products;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Item.
 */
public class Item {
    private String name;
    private String id;
    private Category category;
    private String description;
    private String brand;
    private double price;
    private double weight;
    private double discountPercentage;
    private int quantity = 100;

    /**
     * Instantiates a new Item.
     *
     * @param name               the name
     * @param id                 the id
     * @param category           the category
     * @param description        the description
     * @param brand              the brand
     * @param price              the price
     * @param weight             the weight
     * @param discountPercentage the discount percentage
     * @param quantity           the quantity
     */
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

    /**
     * Instantiates a new Item.
     */

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets discount percentage.
     *
     * @return the discount percentage
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param i the
     */
    public void setQuantity(int i) {
        this.quantity = i;
    }
}


