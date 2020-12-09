package practice.designPatterns.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileLogger implements Logger {
	public FileLogger() {
		log.info("<<< File Logger >>>");
	}

	@Override
	public void log(String message) {
		log.info(message);
	}
}
