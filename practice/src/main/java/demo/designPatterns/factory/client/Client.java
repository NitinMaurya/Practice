package demo.designPatterns.factory.client;

import demo.designPatterns.factory.Logger;
import demo.designPatterns.factory.LoggerFactory;
import demo.designPatterns.factory.LoggerType;

public class Client {
	public static void main(String[] args) {
		Logger inMemoryLogger = LoggerFactory.getInstance(LoggerType.IN_MEMORY_LOGGER);
		inMemoryLogger.log("Hello");

		Logger fileLogger = LoggerFactory.getInstance(LoggerType.FILE_LOGGER);
		fileLogger.log("Hey! there");
	}
}
