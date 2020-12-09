package practice.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProfileApproveNotification implements Notification {
	@Override
	public void send(String message) {
		log.info("Your profile {} is approved", message);
	}
}
