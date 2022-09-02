import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utility.functions.TreeNode;

public class M_BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int height = 0;
		helper(root,height,res);
		return res;
    }
    
	private void helper(TreeNode root, int height,List<List<Integer>> res) {
		if(root != null) {
			if(res.size() <= height) 
				res.add(new ArrayList<Integer>());
			res.get(height).add(root.val);
			helper(root.left, height + 1, res);
			helper(root.right, height + 1, res);
		}
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		M_BinaryTreeLevelOrderTraversal sol = new M_BinaryTreeLevelOrderTraversal();
		System.out.println(sol.levelOrder(root));
	}
}
