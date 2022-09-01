import java.util.Collections;
import java.util.PriorityQueue;

public class H_FindMedianFromDataStream {
	
	private PriorityQueue<Integer> small = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> large = new PriorityQueue<Integer>(Collections.reverseOrder());
	boolean even = true;
    
    public void addNum(int num) {
        if(even) {
            large.offer(num);
        	small.offer(large.poll());
        }
        else {
        	small.offer(num);
        	large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even) 
        	return (small.peek() + large.peek())/2.0;
    	else
    		return small.peek();
    }
}
