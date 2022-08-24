/*
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.
*/

/*
Intution: 
			we just have to add the left and right child of the to_be_deleted node and just have to add the root node of the whole tree to the ans(is it is node included in the to_be_deleted list)....

			First we have to make the recursive call to the left and the right child of the root node...

			and then add the root node if it is included in the to_be_deleted list... 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    List<TreeNode> ans=new ArrayList<>();
    public void solve(TreeNode root,Set<Integer> set,TreeNode par)
    {
        if(root==null) return;
        solve(root.left,set,root);
        solve(root.right,set,root);
        if(set.contains(root.val))
        {
            if(par==null) return;
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
            set.remove(root.val);
            if(par.left!=null && par.left==root) par.left=null;
            if(par.right!=null && par.right==root) par.right=null;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        if(root==null) return ans;
        Set<Integer> set=new HashSet<>();
        for(int i : to_delete)
        {
            set.add(i);
        }
        
        
        solve(root.left,set,root);
        solve(root.right,set,root);
        
        
        if(!set.contains(root.val))
        {
            ans.add(root);
        }
        else
        {
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
        }
        return ans;
    }
}