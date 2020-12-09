package demo.designPatterns.singleton.lazyInitialized;

public class Client {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getI());
		singleton.setI(20);
		Singleton newSingleton = Singleton.getInstance();
		System.out.println(newSingleton.getI());
	}
}
