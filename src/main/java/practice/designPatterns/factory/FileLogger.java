package practice.designPatterns.factory;

public class FileLogger implements Logger {
	public FileLogger() {
		System.out.println("<<< File Logger >>>");
	}

	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
