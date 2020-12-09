package demo.designPatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskOverdueNotification implements Notification {
	@Override
	public void send(String message) {
		log.info("Your task {} has been overdue. Please complete asap.", message);
	}
}
