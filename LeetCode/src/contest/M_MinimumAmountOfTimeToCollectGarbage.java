package contest;

import java.util.HashMap;
import java.util.Map;

public class M_MinimumAmountOfTimeToCollectGarbage {
	
	public int garbageCollection(String[] garbage, int[] travel) {
		
//		int [] distance = new int [garbage.length];
//		int  res = 0;
//		
//		for(int i = 0; i < garbage.length; i++) {
//			if(i != 0)
//				distance[i] = travel[i - 1];
//		}
//		
//		for(int i = 0; i < garbage.length - 1; i++) {
//			int count = 0;
////			if(garbage[0].contains("G")) {
//				
//				String tmp = garbage[i];
//				for(int j = 0; j < tmp.length(); j++) {
//					if(tmp.charAt(j) == 'G')
//						count++;
//					else if(tmp.charAt(j) == 'M')
//						count++;
//					else if(tmp.charAt(j) == 'P')
//						count++;
//				}
//			
//			res += travel[i]*tmp.length() + count;
//		}
//		int countEnd = 0;
//		String lastString = garbage[garbage.length - 1];
//		for(int k = 0; k < lastString.length(); k++) {
//			if(lastString.charAt(k) == 'G')
//				countEnd++;
//			if(lastString.charAt(k) == 'M')
//				countEnd++;
//			if(lastString.charAt(k) == 'P')
//				countEnd++;
//		}
//		return res + countEnd;
		
		// misunderstood the problem
		/*int  res = 0;		
		boolean[] paperTrack = new boolean[garbage.length]; 
		boolean[] glassTrack = new boolean[garbage.length]; 
		boolean[] metalTrack = new boolean[garbage.length];	
		
		for(int l = 0; l < garbage.length - 1; l++) {
			if(!garbage[l].contains("G")) glassTrack[l] = true;
			if(!garbage[l].contains("M")) metalTrack[l] = true;
			if(!garbage[l].contains("P")) paperTrack[l] = true;
		}
		for(int l = garbage.length - 1; l >= 0; l--) {
			if(!garbage[l].contains("G")) glassTrack[l] = true;
			if(!garbage[l].contains("M")) metalTrack[l] = true;
			if(!garbage[l].contains("P")) paperTrack[l] = true;
		}
				
		for(int i = 0; i < garbage.length - 2; i++) {
			int count = 0;
			String tmp = garbage[i];
			for(int j = 0; j < tmp.length(); j++) {
				if(tmp.charAt(j) == 'G') {
					count++;					
				}
				else if(tmp.charAt(j) == 'M') {
					count++;					
				}
				else if(tmp.charAt(j) == 'P') {
					count++;					
				}
			}
			if(!paperTrack[i]) res += travel[i];
			if(!glassTrack[i]) res += travel[i];
			if(!metalTrack[i]) res += travel[i];
			res += count;
		}
		int countEnd = 0;
		String lastString = garbage[garbage.length - 1];
		for(int k = 0; k < lastString.length(); k++) {
			if(lastString.charAt(k) == 'G')
				countEnd++;
			else if(lastString.charAt(k) == 'M')
				countEnd++;
			else if(lastString.charAt(k) == 'P')
				countEnd++;
		}
		return res + countEnd;*/
		
		// recreated based on online
		int res = 0;
		Map<Character, Integer> lastIndex = new HashMap<Character, Integer>();
		int[] prefix = new int[travel.length];
		int sum = 0;
		
		for(int i = 0; i < travel.length; i++) {
			sum += travel[i];
			prefix[i] = sum;
		}
		
		for(int i = 0; i < garbage.length; i++) {
			res += garbage[i].length();
			for(char letter : garbage[i].toCharArray()) {
				lastIndex.put(letter, i);
			}
		}
		
		for(Map.Entry<Character, Integer> i : lastIndex.entrySet()) {
			if(i.getValue() > 0)
				res += prefix[i.getValue() - 1];
		}
		return res;
		
		// took from online optimal
        /*int last[] = new int[128], res = 0;
        for (int i = 0; i < garbage.length; ++i) {
            res += garbage[i].length();
            for (int j = 0; j < garbage[i].length(); ++j)
                last[garbage[i].charAt(j)] = i;
        }
        for (int j = 1; j < travel.length; ++j)
            travel[j] += travel[j - 1];
        for (int c : "PGM".toCharArray())
            if (last[c] > 0)
                res += travel[last[c] - 1];
        return res;*/
		
		// best sol from online 3ms
        /*int res=0;
        int last=0;
        for(int i=1;i<travel.length;i++){
            travel[i]=travel[i-1]+travel[i];
        }
       
        for(int i=0;i<garbage.length;i++){
              res+=garbage[i].length();
            
        }
        for(int i=garbage.length-1;i>=0;i--){
            if(garbage[i].contains("G")){
            if(i!=0)    res+=travel[i-1];
                break;
            }
        }
        for(int i=garbage.length-1;i>=0;i--){
            if(garbage[i].contains("P")){
                if(i!=0)    res+=travel[i-1];
                break;
            }
        }
        for(int i=garbage.length-1;i>=0;i--){
            if(garbage[i].contains("M")){
                if(i!=0)    res+=travel[i-1];
                break;
            }
        }
      
        return res;*/
		
	}
	public static void main(String[] arg) {
		M_MinimumAmountOfTimeToCollectGarbage sol = new M_MinimumAmountOfTimeToCollectGarbage();
		System.out.println(sol.garbageCollection(new String [] {"G","P","GP","GG"}, new int[] {2,4,3}));
		System.out.println(sol.garbageCollection(new String [] {"MMM","PGM","GP"}, new int[] {3,10}));
	}
}
