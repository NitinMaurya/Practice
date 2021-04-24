package practice.designPatterns.abstractFactory;

public class ProfileApproveNotification implements Notification {
	@Override
	public void send(String message) {
		System.out.println("Your profile {" + message + "} is approved");
	}
}
