import java.util.*;

public class M_322_CoinChange {
	
	// correct sol using DFS timelimit exceed
    /*public int minCoin = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        helper(coins,amount,0);
        return minCoin == 0 ? Integer.MAX_VALUE : minCoin;
    }

    public void helper(int[] coins,int amount,int level) {
        if(amount == 0) {
            minCoin = Math.min(level, minCoin);
            return;
        }
        if(amount < 0) return;
        for(int coin : coins) {
            helper(coins,amount - coin ,level + 1);
        }
    }*/
	
	// recreated based on online
	public int coinChange(int[] coins, int amount) {
		
		int[] dp = new int[amount + 1];
		int sum = 0;
		
		while(++sum <= amount) {
			int min = -1;
			for(int coin : coins) {
				if(sum >= coin && dp[sum - coin] != -1) {
					int tmp = dp[sum - coin] + 1;
					min = min < 0 ? tmp : Math.min(tmp, min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
	}
    
    public static void main(String[] args) {
        M_322_CoinChange sol = new M_322_CoinChange();
        System.out.println(sol.coinChange(new int[] {3,5,6},18));
        System.out.println(sol.coinChange(new int[] {1,2,5},11));
        System.out.println(sol.coinChange(new int[] {1,2,5},100));
        System.out.println(sol.coinChange(new int[] {1},0));
        System.out.println(sol.coinChange(new int[] {2},3));
    }
}