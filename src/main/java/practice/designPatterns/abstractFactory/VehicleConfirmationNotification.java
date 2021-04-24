package practice.designPatterns.abstractFactory;

public class VehicleConfirmationNotification implements Notification {
	@Override
	public void send(String message) {
		System.out.println("Your vehicle { "+ message + "} is confirmed.");
	}
}
