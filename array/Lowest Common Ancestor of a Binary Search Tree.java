/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/

/*
Intution: 
			unlike the BT in BST you just have to find the node which lies between the p and q...

			and that node in between is the LCA...
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public TreeNode solve(TreeNode root,TreeNode p, TreeNode q)
    {
        
        if(root.val<p.val && root.val<q.val) return solve(root.right,p,q);
        
        if(root.val>p.val && root.val>q.val) return solve(root.left,p,q);
        
        return root;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        return solve(root,p,q);
    }
}