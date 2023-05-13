package orders;
import products.*;

/**
 * The type Payment.
 */
public class payment {
    private int paymentMethod;

    /**
     * Sets payment method.
     *
     * @param paymentMethod the payment method
     */
    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets payment method.
     *
     * @return the payment method
     */
    public int getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Process payment.
     *
     * @param paymentMethod the payment method
     */
    public void processPayment(int paymentMethod) {
         if(paymentMethod == 1) {
            System.out.println("you will pay  "+ Carts.getTotalPrice()+ "$  with cash");

         }
        else if(paymentMethod == 2) {
            System.out.println("This payment method is not available yet.");
        }
        else {
            System.out.println("Invalid payment method");
        }
    }
}
