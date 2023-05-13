import java.util.List;

public class Orders {
    private int orderId;// skeleton not used for now
    private String customerName;
    private String orderAddress;
    private List<Item> orderItems;
    private double orderTotal;


    public Orders() {
       customerName="";
       orderAddress="";
       orderItems = Carts.getorderItems();
    }

    public void display_bill(){

        System.out.println("\n\nyour bill:");
        System.out.println("--------------------------------------------------");
        System.out.println("Name is "+getCustomerName());
        System.out.println("Shipment its way to "+getOrderAddress());
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s\n", "Name", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        for (Item item : orderItems) {
            System.out.printf("%-20s%-15s%-15s\n", item.getName(), item.getPrice(), item.getQuantity());
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s\n","Total Price&Weight " , Carts.getTotalPrice(), Carts.getTotalQuantity());
        System.out.println("--------------------------------------------------");
        System.out.println("Thank you for shopping with us!");
        System.out.println("See you soon!\n\n");
    }
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

}
