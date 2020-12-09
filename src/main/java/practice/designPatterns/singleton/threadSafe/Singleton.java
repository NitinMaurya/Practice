package practice.designPatterns.singleton.threadSafe;

public class Singleton {
	private volatile static Singleton instance;

	private Singleton(){

	}

	public static Singleton getDoubleCheckedLockingInstance(){
		if(instance == null){
			synchronized (Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	public static synchronized Singleton getMethodSynchronizedLockingInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

	public static Singleton getInstructionSynchronizedLockingInstance(){
		if(instance == null){
			synchronized (Singleton.class){
				instance = new Singleton();
			}
		}
		return instance;
	}
}
