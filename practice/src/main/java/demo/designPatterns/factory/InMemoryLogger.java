package demo.designPatterns.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InMemoryLogger implements Logger {
	public InMemoryLogger() {
		log.info("<<< In Memory Logger >>>");
	}

	@Override
	public void log(String message) {
		log.info(message);
	}
}
