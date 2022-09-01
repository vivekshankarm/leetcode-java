import java.util.ArrayList;
import java.util.List;

import utility.functions.TreeNode;

public class E_BinaryTreePreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	
	private void helper(TreeNode root, List<Integer> res) {
		if(root != null) {
			res.add(root.val);
			helper(root.left,res);
			
			helper(root.right,res);
		}
	}
	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		E_BinaryTreePreorderTraversal sol = new E_BinaryTreePreorderTraversal();
		System.out.println(sol.preorderTraversal(root));
		
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		System.out.println(sol.preorderTraversal(root1));
	}
}
