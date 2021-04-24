package practice.designPatterns.abstractFactory;

import practice.designPatterns.factory.LoggerFactory;

public class CustomerNotificationFactory implements NotificationFactory {

	public CustomerNotificationFactory() {
		System.out.println("Sending customer notification");
	}

	public Notification getNotification(NotificationType notificationType) {
		switch (notificationType){
			case BOOKING_START: return new BookingStartNotification();
			case PAYMENT_PENDING: return new PaymentPendingNotification();
			case PROFILE_APPROVED: return new ProfileApproveNotification();
			case VEHICLE_CONFIRMED: return new VehicleConfirmationNotification();
			default: return null;
		}
	}
}
