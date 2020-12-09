package demo.designPatterns.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoteLogger implements Logger {
	public RemoteLogger() {
		log.info("<<< Remote Logger >>>");
	}

	@Override
	public void log(String message) {
		log.info(message);
	}
}
