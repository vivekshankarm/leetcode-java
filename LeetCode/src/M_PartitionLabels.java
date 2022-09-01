import java.util.ArrayList;
import java.util.List;

public class M_PartitionLabels {
	
    public List<Integer> partitionLabels(String s) {
        
    	int m = s.length();
    	int[] alphabet = new int[128];
    	int count = 0;
    	int max = -1;
    	List<Integer> res = new ArrayList<Integer>();
    	
    	for(int i = 0; i < m; i++) {
    		int index = s.charAt(i);
    		alphabet[index] = i; 
    	}
    	for(int j = 0; j < m; j++) {
    		count += 1;
    		int currValue = alphabet[s.charAt(j)];
    		
    		if(currValue > max) {
    			max = currValue;
    		}
    		if(j == max){
    			res.add(count);
    			count = 0;
    		}
    	}
    	if (count != 0) {
    		res.add(count);
    		return res;
    	}
    	return res; 
    }
    public static void main(String[] arg) {
    	M_PartitionLabels sol = new M_PartitionLabels();
    	System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij"));
    	System.out.println(sol.partitionLabels("eccbbbbdec"));
    	System.out.println(sol.partitionLabels("caedbdedda"));
    }
}
