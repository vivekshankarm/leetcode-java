import java.util.Stack;

import utility.functions.TreeNode;

public class M_230_KthSmallestElementInABST {
	
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while(true) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(--k == 0) return curr.val;
            curr = curr.right;            
        }
    }
}
