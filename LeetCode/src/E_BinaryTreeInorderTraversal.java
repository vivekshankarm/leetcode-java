import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utility.functions.TreeNode;

public class E_BinaryTreeInorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		// using recursion
		/*List<Integer> res = new ArrayList<Integer>();
		helper(root, res);
		return res;
	}
	
	private void helper(TreeNode root, List<Integer> res) {
		if(root != null) {
			helper(root.left,res);
			res.add(root.val);
			helper(root.right,res);
		}
	}*/
		
		// using stack
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();		
		TreeNode curr = root;
//		stack.add(curr);
		
		while(curr != null || !stack.isEmpty() ) {
			while(curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
		
	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		E_BinaryTreeInorderTraversal sol = new E_BinaryTreeInorderTraversal();
		System.out.println(sol.inorderTraversal(root));
		
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		System.out.println(sol.inorderTraversal(root1));
		
	}
}
