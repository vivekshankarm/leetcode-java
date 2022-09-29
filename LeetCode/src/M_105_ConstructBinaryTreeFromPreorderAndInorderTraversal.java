import java.util.HashMap;
import java.util.Map;

import utility.functions.TreeNode;

public class M_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
    public int preorderIndex;
    public Map<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();
    
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int left = 0;
        int right = preorder.length - 1;
		preorderIndex = 0;
        
        for(int i = 0; i < preorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return helper(preorder, left, right);
	}
	
	private TreeNode helper(int[] preorder,int left, int right) {
		if(left > right) return null;
        
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = helper(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = helper(preorder, inorderMap.get(rootValue) + 1, right);
        
        return root;
	}
}
