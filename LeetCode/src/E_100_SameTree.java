import utility.functions.TreeNode;

public class E_100_SameTree {
	
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
	
	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
//		root1.left.left.right = new TreeNode(6);
		
		E_100_SameTree sol = new E_100_SameTree();
		System.out.println(sol.isSameTree(root, root));
		System.out.println(sol.isSameTree(root, root1));
		System.out.println(sol.isSameTree(root1, root));
	}
}
