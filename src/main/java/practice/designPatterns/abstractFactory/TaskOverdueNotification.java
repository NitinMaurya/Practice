package practice.designPatterns.abstractFactory;

public class TaskOverdueNotification implements Notification {
	@Override
	public void send(String message) {
		System.out.println("Your task { " + message + " } has been overdue. Please complete asap.");
	}
}
