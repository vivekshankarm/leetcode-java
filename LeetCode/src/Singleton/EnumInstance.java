package Singleton;

public class EnumInstance {
	
	public static void main(String[] arg) {
		Xyz3 obj1 = Xyz3.INSTANCE;
		System.out.println(obj1);
		
		obj1.i = 5;
		obj1.show();
		
		Xyz3 obj2 = Xyz3.INSTANCE;
		obj2.i = 6;
		obj2.show();
	}
	
}

enum Xyz3 {
	INSTANCE;
	
//	public static Xyz3 getInstance() {}
	
	int i;
	public void show() {
		System.out.println(i);
	}
}