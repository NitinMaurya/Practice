package practice.designPatterns.factory;

public class LoggerFactory {
	private LoggerFactory(){

	}

	public static Logger getInstance(LoggerType loggerType){
		switch (loggerType){
			case DISK_LOGGER: return new DiskLogger();
			case FILE_LOGGER: return new FileLogger();
			case REMOTE_LOGGER: return new RemoteLogger();
			case IN_MEMORY_LOGGER:
			default: return new InMemoryLogger();
		}
	}
}
