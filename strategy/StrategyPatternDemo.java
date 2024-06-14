package strategy;

/**
 * 
 * @author Ahmad Alrefai
 */
//Strategy interface
interface PaymentStrategy {
	void pay(int amount);
}

//Concrete strategies
class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}
}

class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;

	public PaypalStrategy(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using PayPal.");
	}
}

//Context
class ShoppingCart {
	private PaymentStrategy paymentStrategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void pay(int amount) {
		paymentStrategy.pay(amount);
	}
}

public class StrategyPatternDemo {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		// Pay with credit card
		cart.setPaymentStrategy(new CreditCardStrategy("John Doe", "1234567890123456", "123", "12/25"));
		cart.pay(100);

		// Pay with PayPal
		cart.setPaymentStrategy(new PaypalStrategy("john@example.com", "mypassword"));
		cart.pay(200);
	}
}
