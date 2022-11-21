/*
 Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
Return the root of the reversed tree.

A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

The level of a node is the number of edges along the path between it and the root node.
 */
import java.util.*;

import javax.swing.tree.TreeNode;
class Main
{
    public void reverseList(ArrayList<TreeNode> list)
    {
        int l=0;
        int r=list.size()-1;
        while(l<r)
        {
            int tmp=list.get(l).val;
            list.get(l).val=list.get(r).val;
            list.get(r).val=tmp;
            ++l;
            --r;
        }
    }
    public TreeNode reverseOddLevels(TreeNode root) 
    {
        int level=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {

            ArrayList<TreeNode> list=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;++i)
            {
                TreeNode tmp=q.poll();
                if(tmp.left!=null) list.add(tmp.left);
                if(tmp.right!=null) list.add(tmp.right);
            }
            if(level%2==1) reverseList(list);

            for(TreeNode i : list) q.add(i);
            ++level;
        }
    }
}