import java.util.ArrayList;
import java.util.List;

public class cart {
    private List<Item> items;

    public cart() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public List<Item> getItems() {
        return this.items;
    }
}
