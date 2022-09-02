package Singleton;

public class LazyInstanceSingleton {

	public static void main(String[] arg) {
		
		Xyz obj1 = Xyz.getInstance();
		Xyz obj2 = Xyz.getInstance();
	}
}

class Xyz {
	
	static Xyz obj; 
	
	private Xyz() {
		System.out.println("Instance created");
	}
	
	public static Xyz getInstance() {
		
		if(obj == null)
			obj = new Xyz();
		return obj;
	}
}

// when multi-thread used it may create two objects so base prop will get violated
