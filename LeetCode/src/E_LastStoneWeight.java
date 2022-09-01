import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class E_LastStoneWeight {
	
//	public int lastStoneWeight(int[] stones) {
//	    Arrays.sort(stones);
//	    System.out.println(Arrays.toString(stones));
//	    for(int i=stones.length-1; i>0; i--) {
//	      stones[i-1] = stones[i] - stones[i-1];
//	      System.out.println(Arrays.toString(stones));
//	      Arrays.sort(stones);
//	    }
//	    return stones[0];
//	  }
	
    public int lastStoneWeight(int[] A) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)-> b-a);
		
    	for(int a : A) {
    		pq.add(a);
    	}
    	
    	while(pq.size() > 1) {
    		pq.add(pq.poll() - pq.poll());
    	}
    	return pq.poll();
    }

    
	public static void main(String[] arg) {
		E_LastStoneWeight sol = new E_LastStoneWeight();
		int[] x = {2,7,4,1,8,1}; 
		System.out.println(sol.lastStoneWeight(x));
	}
}
