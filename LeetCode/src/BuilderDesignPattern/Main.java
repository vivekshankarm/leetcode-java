package BuilderDesignPattern;

public class Main {
	public static void main(String[] arg) {
		Phone sol = new PhoneBuilder().setBattery(0).setCamera(10).setProcessor("intel").getPhone();
		
		System.out.println(sol);
	}
}
