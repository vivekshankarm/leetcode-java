package AdapterDesignPattern;

public class School {

	public static void main(String[] args) {
		
		Pen p = new PenAdapter();
		AssianmentWork aw = new AssianmentWork();
		aw.setPen(p);
		aw.writeAssignment("to the assignment using pen");
	}
}
