import utility.functions.TreeNode;

public class E_226_InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
        swapNextPointer(root);
        return root;
    }
    private void swapNextPointer(TreeNode root) {
        if(root == null) return;
        // if(root.left != null || root.right) {
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        swapNextPointer(root.left);
        swapNextPointer(root.right);

    }
}
