package zoho;

import java.util.stream.IntStream;

public class M_CircularTour {
	
	public int tour(int petrol[], int distance[]) {
		
		if(IntStream.of(petrol).sum() < IntStream.of(distance).sum()) return -1;
//		int x = (petrol) -> 
		int balance = 0;
		int res = 0;
		
		for(int i = 0; i < petrol.length; i++) {
			balance += petrol[i] - distance[i];
			if(balance < 0) {
				balance = 0;
				res = i + 1;
			}
		}
		return res;
	}
	public static void main(String[] arg) {
		M_CircularTour sol = new M_CircularTour();
		System.out.println(sol.tour(new int[] {4,6,7,4}, new int[] {6,5,3,5}));
		System.out.println(sol.tour(new int[] {2,3,4}, new int[] {3,4,3}));
		System.out.println(sol.tour(new int[] {3,1,1}, new int[] {1,2,2}));
		System.out.println(sol.tour(new int[] {4,5,2,6,5,3}, new int[] {3,2,7,3,2,9}));
	}
}
