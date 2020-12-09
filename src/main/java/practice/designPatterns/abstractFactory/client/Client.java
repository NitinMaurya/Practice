package practice.designPatterns.abstractFactory.client;

import practice.designPatterns.abstractFactory.Notification;
import practice.designPatterns.abstractFactory.NotificationFactory;
import practice.designPatterns.abstractFactory.NotificationType;

public class Client {
	public static void main(String[] args) {
		Notification notification1 = NotificationFactory.getInstance(NotificationType.TASK_COMPLETE);
		notification1.send("Task 1");

		Notification notification2 = NotificationFactory.getInstance(NotificationType.BOOKING_START);
		notification2.send("2");
	}
}
