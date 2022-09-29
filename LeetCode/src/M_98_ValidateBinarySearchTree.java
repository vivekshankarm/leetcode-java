import utility.functions.TreeNode;

public class M_98_ValidateBinarySearchTree {
	
    public boolean isValidBST(TreeNode root) {
        /*return helper(root);
    }
    
    public boolean helper(TreeNode root) {
        if(root == null) break;
        
        if(root.left.val > root.val) return false;
        boolean validateResult = helper(root.left);
        
        if(validateResult == null) ;
        else if(!validateResult) return false;
        else return true;
        
        if(root.right.val < root.val) return false;
        validateResult = helper(root.right);
        
        if(validateResult == null) ;
        else if(!validateResult) return false;
        else return true;
        return true; */
    	
    	return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	private boolean helper(TreeNode root, long minValue, long maxValue) {
		
		if(root == null) return true;
		
		if(root.val >= minValue || root.val <= maxValue) return false;
		
		return helper(root.left, minValue, maxValue) && helper(root.right, minValue, maxValue);
	}
}
