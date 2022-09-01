// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class M_BestTimeToBuySellStock {
	
	public int maxProfit(int[] prices) {
		int maxValue = 0;
		int minValue = prices[0];
		
		for(int i = 0; i < prices.length; i++) {
			if (prices[i] < minValue) {
				minValue = prices[i];
			} 
			if ((prices[i] - minValue) > maxValue) {
				maxValue = prices[i] - minValue;
			}
		}
		return maxValue;		
	}
	public static void main(String[] arg) {
		M_BestTimeToBuySellStock sol = new M_BestTimeToBuySellStock();
		int[] prices = {7,1,5,3,6,8};
		System.out.println(sol.maxProfit(prices));
	}
}
