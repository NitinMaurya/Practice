package practice.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserNotificationFactory implements NotificationFactory {

	public UserNotificationFactory() {
		log.info("Sending User notification");
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
