public class payment {
    private int paymentMethod;

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

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
