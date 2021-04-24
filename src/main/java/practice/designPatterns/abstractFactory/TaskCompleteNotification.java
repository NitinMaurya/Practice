package practice.designPatterns.abstractFactory;


public class TaskCompleteNotification implements Notification {
	@Override
	public void send(String message) {
		System.out.println("Your task { " + message + "} has been completed.");
	}
}
