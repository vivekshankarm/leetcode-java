import java.util.Arrays;

import utility.functions.TreeNode;

public class E_104_MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		int[] res = {0};
		helper(root,1,res);
		return res[0];
	}
	private void helper(TreeNode root, int level, int[] res) {
		// TODO Auto-generated method stub
		if(root != null) {
			res[0] = Math.max(res[0], level);
			helper(root.left, level + 1, res);
			helper(root.right, level + 1, res);
		}
	}
	public static void main(String[] arg) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(10);
		
		E_104_MaximumDepthOfBinaryTree sol = new E_104_MaximumDepthOfBinaryTree();
		System.out.println(sol.maxDepth(root));
	}
}
