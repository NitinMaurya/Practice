package practice.designPatterns.singleton.innerClassBased;

public class Singleton implements Cloneable {

	private Singleton(){}

	private static class SingletonHelper{
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance(){
		return SingletonHelper.INSTANCE;
	}

	@Override
	public Singleton clone() {
		return getInstance();
	}
}
