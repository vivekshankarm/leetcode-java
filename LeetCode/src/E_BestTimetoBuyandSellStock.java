
public class E_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		
		// correct sol
		/*int max = 0;
		int minIndex = 0;
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < prices[minIndex]) 
				minIndex = i;
			max = Math.max(max, prices[i] - prices[minIndex]);
		}
		return max;*/
		
		// more optimal from online
        int StockProfit = 0;
        int minPrice = Integer.MAX_VALUE;	// if else designed nicely, min and max wont come in same index 
        for(int i=0;i<prices.length;i++){	// so any condition need to executed
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if(prices[i]-minPrice>StockProfit){
                StockProfit=prices[i]-minPrice;
            }
        }
        return StockProfit;
	}
	
	public static void main(String[] arg) {
		E_BestTimetoBuyandSellStock sol = new E_BestTimetoBuyandSellStock();
		System.out.println(sol.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(sol.maxProfit(new int[] {7,6,4,3,1}));
		System.out.println(sol.maxProfit(new int[] {1,2,3,4,5}));
	}
}
