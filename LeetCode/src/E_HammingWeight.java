
public class E_HammingWeight {
	public int hammingWeight(int n) {
		int count = 0;
		
		while(n != 0) {
			count += n & 1;
			n = n >>> 1;
			System.out.println(n);
		}
		return count;
	}
	public static void main(String[] arg) {
		E_HammingWeight sol = new E_HammingWeight();
		System.out.println(sol.hammingWeight(0000000001011));
		//System.out.println(sol.hammingWeight(00000000000000000000000010000000));
		//System.out.println(sol.hammingWeight(11111111111111111111111111111101));
	}
}
