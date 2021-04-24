package practice.designPatterns.abstractFactory;


public class UserNotificationFactory implements NotificationFactory {

	public UserNotificationFactory() {
		System.out.println("Sending User notification");
	}

	@Override
	public Notification getNotification(NotificationType notificationType) {
		switch (notificationType){
			case TASK_OVERDUE: return new TaskOverdueNotification();
			case TASK_COMPLETE: return new TaskCompleteNotification();
			default: return null;
		}
	}
}
