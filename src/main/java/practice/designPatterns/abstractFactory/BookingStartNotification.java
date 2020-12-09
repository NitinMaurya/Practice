package practice.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookingStartNotification implements Notification {
	@Override
	public void send(String message) {
		log.info("Your booking {} about to start at 12 pm", message);
	}
}
