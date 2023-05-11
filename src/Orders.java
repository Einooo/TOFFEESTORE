import java.util.List;

public class Orders {
    private int orderId;// skeleton not used for now
    private String customerName;
    private String orderAddress;

    private List<Item> orderItems;
    private double orderTotal;

    public Orders( String customerName, String orderAddress) {
        this.customerName = customerName;
        this.orderAddress = orderAddress;
        this.orderItems = Carts.getcartItems();
    }

    public void display_bill(){
        System.out.printf("%-20s%Toffee Store:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s\n", "Name", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        for (Item item : orderItems) {
            System.out.printf("%-20s%-15s%-15s\n", item.getName(), item.getPrice(), item.getQuantity());
        }
        System.out.println("--------------------------------------------------");
    }
    // Getters and setters for all properties

    public int getOrderId() {
        return orderId;
    }// skeleton not used for now


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    } // skeleton not used for now

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
