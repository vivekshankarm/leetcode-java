import java.util.ArrayList;
import java.util.List;

import utility.functions.TreeNode;

public class E_BinaryTreePostorderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	
	private void helper(TreeNode root, List<Integer> res) {
		if(root != null) {
			
			helper(root.left,res);
			
			helper(root.right,res);
			res.add(root.val);
		}
	}
	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		E_BinaryTreePostorderTraversal sol = new E_BinaryTreePostorderTraversal();
		System.out.println(sol.postorderTraversal(root));
		
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		System.out.println(sol.postorderTraversal(root1));
	}
}
