package practice.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskCompleteNotification implements Notification {
	@Override
	public void send(String message) {
		log.info("Your task {} has been completed.", message);
	}
}
