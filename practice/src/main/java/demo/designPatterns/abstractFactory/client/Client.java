package demo.designPatterns.abstractFactory.client;

import demo.designPatterns.abstractFactory.Notification;
import demo.designPatterns.abstractFactory.NotificationFactory;
import demo.designPatterns.abstractFactory.NotificationType;

public class Client {
	public static void main(String[] args) {
		Notification notification1 = NotificationFactory.getInstance(NotificationType.TASK_COMPLETE);
		notification1.send("Task 1");

		Notification notification2 = NotificationFactory.getInstance(NotificationType.BOOKING_START);
		notification2.send("2");
	}
}
