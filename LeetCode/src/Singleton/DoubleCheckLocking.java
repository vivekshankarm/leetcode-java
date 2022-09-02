package Singleton;

public class DoubleCheckLocking {

	public static void main(String[] arg) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Xyz2 obj1 = Xyz2.getInstance();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				Xyz2 obj1 = Xyz2.getInstance();
			}
		});
		t1.start();
		System.out.println("test");
//		try {Thread.sleep(10);} catch(Exception e) {};
		t2.start();
	}
}

class Xyz2 {
	
	static Xyz2 obj; 
	
	private Xyz2() {
		System.out.println("Instance created");
	}
	
	public static Xyz2 getInstance() { 
		
		if(obj == null) {
			synchronized(Xyz2.class) {
				if(obj == null)
					obj = new Xyz2();
			}
		}
			
		return obj;
	}
}
