package practice.designPatterns.factory.client;

import practice.designPatterns.factory.Logger;
import practice.designPatterns.factory.LoggerFactory;
import practice.designPatterns.factory.LoggerType;

public class Client {
	public static void main(String[] args) {
		Logger inMemoryLogger = LoggerFactory.getInstance(LoggerType.IN_MEMORY_LOGGER);
		inMemoryLogger.log("Hello");

		Logger fileLogger = LoggerFactory.getInstance(LoggerType.FILE_LOGGER);
		fileLogger.log("Hey! there");
	}
}
