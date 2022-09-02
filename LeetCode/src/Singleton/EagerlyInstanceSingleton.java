package Singleton;

public class EagerlyInstanceSingleton {
	
	public static void main(String[] arg) {
//		Abc obj = new Abc();
//		Abc obj1 = new Abc();
		
		Abc obj1 = Abc.getInstance();
		Abc obj2 = Abc.getInstance();
	}
}

class Abc {
	
	static Abc obj = new Abc();  // object created everytime and even unnecessarily and it may stay in memory so Lazy instance came
	
	private Abc() {
		
	}
	
	public static Abc getInstance() {
		return obj;
	}
}
