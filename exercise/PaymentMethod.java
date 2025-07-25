public class PaymentMethod {
    public void processPayment(double amount) {
        // Generic implementation
    }
}

public class CreditCardPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Credit card-specific implementation
    }
}
