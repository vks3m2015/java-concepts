package design_patterns.strategy.demo1;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
