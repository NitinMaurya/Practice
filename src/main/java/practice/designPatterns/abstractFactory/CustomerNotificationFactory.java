package practice.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerNotificationFactory implements NotificationFactory {

	public CustomerNotificationFactory() {
		log.info("Sending customer notification");
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
