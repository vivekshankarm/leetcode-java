
public class E_70_ClimbingStairs {
	
    public int climbStairs(int n) {
    	
    	// correct sol but timelimit exceed
		/*if(n == 0) return 0;
		if(n == 1) return 1;
    	if(n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2); */
    	
    	if(n == 1) return 1;
    	if(n == 2) return 2;
    	int first = 1, second = 1;
    	int res = 0;
    	
    	for(int i = 2; i <= n; i++) {
    		res = first + second;
    		second = first;
    		first = res;
    	}
    	return res;
    }
	
	
	public static void main(String[] arg) {
		E_70_ClimbingStairs sol = new E_70_ClimbingStairs();
		System.out.println(sol.climbStairs(2));
		System.out.println(sol.climbStairs(3));
		System.out.println(sol.climbStairs(45));
	}
}
