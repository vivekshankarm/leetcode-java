package Singleton;

public class SynchronizedGetInstance {

	public static void main(String[] arg) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Xyz1 obj1 = Xyz1.getInstance();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				Xyz1 obj1 = Xyz1.getInstance();
			}
		});
		t1.start();
		System.out.println("test");
		t2.start();
	}
}

class Xyz1 {
	
	static Xyz1 obj; 
	
	private Xyz1() {
		System.out.println("Instance created");
	}
	
	public static synchronized Xyz1 getInstance() { // synchronized took more time so Double check locking came
		
		if(obj == null)
			obj = new Xyz1();
		return obj;
	}
}
