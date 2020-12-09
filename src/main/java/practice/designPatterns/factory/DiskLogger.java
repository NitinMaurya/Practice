package practice.designPatterns.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiskLogger implements Logger {
	public DiskLogger() {
		log.info("<<< Disk Logger >>>");
	}

	@Override
	public void log(String message) {
		log.info(message);
	}
}
