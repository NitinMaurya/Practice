package practice.designPatterns.factory;

public class RemoteLogger implements Logger {
	public RemoteLogger() {
		System.out.println("<<< Remote Logger >>>");
	}

	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
