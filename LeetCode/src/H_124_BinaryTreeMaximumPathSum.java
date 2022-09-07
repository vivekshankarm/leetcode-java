import utility.functions.TreeNode;

public class H_124_BinaryTreeMaximumPathSum {
//	public static int[] res = {0,0};

		// wrong misunderstood the pbm
		/*helper(root,1, 0);
		return res[1];
	}
	
	private void helper(TreeNode root, int level,int prevSum) {
		if(root != null) {
			if(level > res[0]) {
				res[1] = prevSum + root.val;
				res[0] = level;
			}
			helper(root.left, level + 1,prevSum + root.val);
			helper(root.right,level + 1,prevSum + root.val);
		}*/
	
	int res = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {	
		helper(root);
		return res;
	}

	private int helper(TreeNode root) {
		if(root == null) return 0;
		
		int left = helper(root.left);
		int right = helper(root.right);
		
		int case1 = Math.max(Math.max(left + root.val, right + root.val), root.val);
		int case2 = Math.max(left + right + root.val, case1);
		res = Math.max(res, case2);
		
		return case1;
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		root.right.left = new TreeNode(14);
		
		H_124_BinaryTreeMaximumPathSum sol = new H_124_BinaryTreeMaximumPathSum();
		System.out.println(sol.maxPathSum(root));
	}
}
