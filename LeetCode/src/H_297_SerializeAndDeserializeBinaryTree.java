import utility.functions.TreeNode;

public class H_297_SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
	public int index;
    public String serialize(TreeNode root) {
    	StringBuilder str = new StringBuilder();
        helper(root,str);     
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    private void helper(TreeNode root,StringBuilder str) {
		if(root == null) {
			str.append("N,");
			return;
		}		
		str.append(Integer.toString(root.val)+ ",");
		helper(root.left,str);
		helper(root.right,str);	
	}

	// Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        index = 0;       
        return helper(dataArr);
    }
    
    private TreeNode helper(String[] dataArr) {
    	
		if(index >= dataArr.length || dataArr[index].equals("N")) return null;
		
		int val = Integer.parseInt(dataArr[index]);
		TreeNode root = new TreeNode(val);
		index++;
		root.left = helper(dataArr);
		index++;
		root.right = helper(dataArr);
		return root;
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(6);
		
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);		
		
		H_297_SerializeAndDeserializeBinaryTree sol = new H_297_SerializeAndDeserializeBinaryTree();
		System.out.println(sol.serialize(root));
		System.out.println(sol.serialize(root1));
		
		System.out.println(sol.serialize(sol.deserialize(sol.serialize(root))));
		System.out.println(sol.serialize(sol.deserialize(sol.serialize(root1))));
    }
}
