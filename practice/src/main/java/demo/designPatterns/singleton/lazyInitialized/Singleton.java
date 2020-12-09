package demo.designPatterns.singleton.lazyInitialized;

public final class Singleton {
	private int i = 10;
	private static Singleton instance;

	private Singleton() { }

	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
