// PaymentMethod.java
public class PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Processing generic payment of $" + amount);
    }
}

// CreditCardPayment.java
public class CreditCardPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

// PayPalPayment.java
public class PayPalPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

// PaymentExample.java
public class PaymentExample {
    public static void main(String[] args) {
        PaymentMethod payment1 = new CreditCardPayment();
        PaymentMethod payment2 = new PayPalPayment();

        payment1.processPayment(100.0);
        payment2.processPayment(200.0);
    }
}
