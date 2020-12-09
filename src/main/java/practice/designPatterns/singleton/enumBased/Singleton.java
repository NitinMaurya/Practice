package practice.designPatterns.singleton.enumBased;

public enum Singleton {
	INSTANCE;
	public static Singleton getInstance(){
		return Singleton.INSTANCE;
	}
}
