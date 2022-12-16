/*
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.
*/

import java.util.*;

class Solution 
{
    int ans=0;
    public int solve(TreeNode root,boolean right)
    {
        if(root==null) return -1;

        if(right)
        {
            int rightG=1+solve(root.right,false);
            int begL=1+solve(root.left,true);
            ans=Math.max(ans,Math.max(rightG,begL));
            return rightG;
        }
        else
        {
            int left=1+solve(root.left,true);
            int begR=1+solve(root.right,false);
            ans=Math.max(ans,Math.max(left,begR));
            return left;
        }
    }
    public int longestZigZag(TreeNode root) 
    {
        if(root.left==null && root.right==null) return 0;

        solve(root,true);
        solve(root,false);
        return ans;

    }    
}