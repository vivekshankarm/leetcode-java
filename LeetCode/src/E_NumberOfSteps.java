
public class E_NumberOfSteps {
	public int numberOfSteps(int num) {
        int count = 0;
		while(num != 0) {
			if(num%2 == 1) {
				num = num - 1;
			}
			else {
				num = num/2;
			}
			count++;
		}
		return count;
    }
	public static void main(String[] arg) {
		E_NumberOfSteps sol = new E_NumberOfSteps();
		System.out.println(sol.numberOfSteps(0));
		System.out.println(sol.numberOfSteps(123));
		System.out.println(sol.numberOfSteps(14));
		System.out.println(sol.numberOfSteps(8));
	}
}
