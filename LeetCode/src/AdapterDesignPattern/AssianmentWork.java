package AdapterDesignPattern;

public class AssianmentWork {
	
	private Pen p;
	
	public void setPen(Pen p) {
		this.p = p;
	}
	public Pen getPen() {
		return this.p;
	}
	
	public void writeAssignment(String str) {
		p.write(str);
	}
}
