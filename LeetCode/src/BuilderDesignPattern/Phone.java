package BuilderDesignPattern;

public class Phone {
	
	private String os;
	private String processor;
	private double screenSize;
	private int battery;
	private int camera;
	
	public Phone(String os, String processor, double screenSize, int battery, int camera) {
//		super();
		this.os = os;
		this.processor = processor;
		this.screenSize = screenSize;
		this.battery = battery;
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "Phone [os=" + os + ", processor=" + processor + ", screenSize=" + screenSize + ", battery=" + battery
				+ ", camera=" + camera + "]";
	}
		
}
