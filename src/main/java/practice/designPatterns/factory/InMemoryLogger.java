package practice.designPatterns.factory;

public class InMemoryLogger implements Logger {
	public InMemoryLogger() {
		System.out.println("<<< In Memory Logger >>>");
	}

	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
