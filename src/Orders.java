import java.util.List;

public class Orders {
    private int orderId;
    private String customerName;
    private String orderAddress;

    private List<Item> orderItems;
    private double orderTotal;

    public Orders(int orderId, String customerName, String orderAddress, List<Item> orderItems) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAddress = orderAddress;
        this.orderItems = Carts.getcartItems();
        this.orderTotal = calculateOrderTotal();
    }

    private double calculateOrderTotal() {
        double total = 0.0;
        for (Item item : orderItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    // Getters and setters for all properties

    public int getOrderId() {
        return orderId;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

public String getOrderAddress() {
        return orderAddress;
    }
    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }


    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
}
