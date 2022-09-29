import utility.functions.TreeNode;

public class M_235_LowestCommonAncestorOfaBinarySearchTree {
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        while(root != null){
            if(root.val < p.val && root.val < q.val) 
                root = root.right;
            
            else if(root.val > p.val && root.val > q.val) 
                root = root.left;
            else return root;
        }
        return root;
        
        // other sol
        /*if(root.val == p.val || root.val == q.val)
            return root;
        if(p.val < root.val && q.val >root.val)
            return root;
        if(p.val > root.val && q.val < root.val)
            return root;
        if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        return lowestCommonAncestor(root.left,p,q);
        */
        
        // other sol
        /*if(root==null) return root;
        if(p.val < root.val && q.val < root.val)
        {return lowestCommonAncestor(root.left,p,q);}
        else if(p.val > root.val && q.val > root.val)
        {return lowestCommonAncestor(root.right, p, q);}
        else
        {return root;}
        */
    }
}
