package Test;

public class TestStaticVariable {

	public static int num;

//	public int test;
//	this.test = 5;		//doubt

	public int test() {
		this.num = 5;
		return this.num;
	}

	public static void main(String[] arg) {
		TestStaticVariable sol = new TestStaticVariable();
		System.out.println(sol.num);
		sol.num = 10;
		System.out.println(sol.num);

		TestStaticVariable sol1 = new TestStaticVariable();
		System.out.println(sol1.num);
		sol.num = 12;
		System.out.println(sol1.num);
		System.out.println(sol.num);
		System.out.println(sol.test());
	}
}
