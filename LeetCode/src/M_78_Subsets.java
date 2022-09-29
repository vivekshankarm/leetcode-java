import java.util.*;

public class M_78_Subsets {
    
    public List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        
        res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        helper(nums,0);
        return res;
    }
    public void helper(int[] nums, int index) {
        if(index >= nums.length) return;
        //System.out.println(res);
        List<Integer> lastList = new ArrayList<Integer>(res.get(res.size()-1));
        
        helper(nums,index + 1);
        lastList.add(nums[index]);
        res.add(lastList);
        helper(nums,index + 1);
    }
    
    public static void main(String[] args) {
        M_78_Subsets sol = new M_78_Subsets();
        System.out.println(sol.subsets(new int[] {1,2,3}));
        System.out.println(sol.subsets(new int[] {0}));
    }
}