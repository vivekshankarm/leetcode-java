
public class M_MirrorReflection {
	
    public int mirrorReflection(int p, int q) {
    	int m = 1, n = 1;
    	
    	while (p*m != q*n) {
    		n++;
    		m = (q*n)/p;
    	}
        if(n % 2 == 0) {
        	return 2;
        }
        else if(m % 2 == 0)
        	return 0;
        return 1;
    }
    public static void main(String[] arg) {
    	M_MirrorReflection sol = new M_MirrorReflection();
    	System.out.println(sol.mirrorReflection(2, 1));
    	System.out.println(sol.mirrorReflection(3, 1));
    	System.out.println(sol.mirrorReflection(3, 2));
    }
}
