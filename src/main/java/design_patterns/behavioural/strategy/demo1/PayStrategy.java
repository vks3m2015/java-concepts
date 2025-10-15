package design_patterns.behavioural.strategy.demo1;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
