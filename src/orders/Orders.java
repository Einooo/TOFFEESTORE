package orders;

import  products.*;

import java.util.List;

/**
 * The type Orders.
 */
public class Orders {
    private int orderId;// skeleton not used for now
    private String customerName;
    private String orderAddress;
    private List<Item> orderItems;
    private Boolean PaymentStatus;


    /**
     * Instantiates a new Orders.
     */
    public Orders() {
       orderItems = Carts.getorderItems();
    }

    /**
     * Display bill.
     */
    public void display_bill(){

        System.out.println("\n\nyour bill:");
        System.out.println("--------------------------------------------------");
        System.out.println("Name is "+getCustomerName());
        System.out.println("Shipment on way to "+getOrderAddress());
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

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId() {
        return orderId;
    }// skeleton not used for now


    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    } // skeleton not used for now

    /**
     * Gets customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets customer name.
     *
     * @param customerName the customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets order address.
     *
     * @return the order address
     */
    public String getOrderAddress() {
        return orderAddress;
    }

    /**
     * Sets order address.
     *
     * @param orderAddress the order address
     */
    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

}
