package demo.designPatterns.abstractFactory;

public interface NotificationFactory {
	Notification getNotification(NotificationType notificationType);

	static Notification getInstance(NotificationType notificationType){
		switch (notificationType){
			case TASK_OVERDUE:
			case TASK_COMPLETE: return new UserNotificationFactory().getNotification(notificationType);
			case VEHICLE_CONFIRMED:
			case BOOKING_START:
			case PAYMENT_PENDING:
			case PROFILE_APPROVED: return new CustomerNotificationFactory().getNotification(notificationType);
			default: return null;
		}
	}

}
