package practice.designPatterns.abstractFactory;

public class PaymentPendingNotification implements Notification {
	@Override
	public void send(String message) {
		System.out.println("your payment {" + message+ "} is pending for booking");
	}
}
