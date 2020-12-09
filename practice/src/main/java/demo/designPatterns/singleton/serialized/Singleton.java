package demo.designPatterns.singleton.serialized;

import java.io.Serializable;

public class Singleton implements Serializable {
	private static final long serialVersionUID = -7604766932017737115L;

	private Singleton() {
	}

	public static Singleton getInstance() {
		return SingletonHelper.instance;
	}

	private static class SingletonHelper {
		private static final Singleton instance = new Singleton();
	}

	protected Object readResolve() {
		return getInstance();
	}
}
