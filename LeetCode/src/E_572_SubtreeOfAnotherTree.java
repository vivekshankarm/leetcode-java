import utility.functions.TreeNode;

public class E_572_SubtreeOfAnotherTree {
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
	    if(subRoot == root) return true;
	    if(subRoot == null) return false;
	    return helper(root,subRoot);
	}
	public boolean helper(TreeNode root, TreeNode subRoot){
	    
	    if(isSameTree(root, subRoot)) return true;
	    if(root.left != null)
	        if(helper(root.left, subRoot)) return true;
	    if(root.right != null)
	        if(helper(root.right, subRoot)) return true;
	    return false;
	}
	    
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(p == null && q != null) return false;
		if(p != null && q == null) return false;
		if(p != null && q != null) {
			
			if(p.val == q.val) {
				if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) return true;		
				else return false;
			}
			else return false;
		}
		return true;
	}
}
