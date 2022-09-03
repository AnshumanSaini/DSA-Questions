/*
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.
*/

/*
Inutuion: 
			as we know preorder traversal means "Root-Left-Right" and postorder traversal means "Left-Right-Root"......

			so, the first element of the preorder traversal is the root node and the second element will belong to the left subtree, and the same element will belong to the postorder traversal but from lower to upper......

			so, we have to find the location of the second element from the preorder traversal in the postorder traversal, and count the no of elements from that index.....

			and then we have to reduce the pointers using that index and count value, using divide and conqure.......
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
    public TreeNode solve(int[] pre,int ps,int pe,int[] post,int pos,int poe)
    {
        
        if(ps>pe) return null;
        
        TreeNode node=new TreeNode(pre[ps]);
        
        if(ps==pe) return node;
        
        int index=-1;
        
        for(int i=pos;i<=poe;++i)
        {
            if(post[i]==pre[ps+1]) 
            {
                index=i;
                break;
            }
        }
        
        int count=index-pos+1;
        
        node.left=solve(pre,ps+1,ps+count,post,pos,index);
        node.right=solve(pre,ps+count+1,pe,post,index+1,poe-1);
        
        return node;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) 
    {
        return solve(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
}