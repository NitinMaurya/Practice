package practice.designPatterns.factory;


public class DiskLogger implements Logger {
	public DiskLogger() {
		System.out.println("<<< Disk Logger >>>");
	}

	@Override
	public void log(String message) {
		System.out.println(message);
	}
}
