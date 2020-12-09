package practice.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleConfirmationNotification implements Notification {
	@Override
	public void send(String message) {
		log.info("Your vehicle {} is confirmed.", message);
	}
}
