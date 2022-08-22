/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
*/

/*
Intution:
			we have to perform the level order traversal in the first and store the left and right child of the all the nodes at the current level in the list...

			and then upload the list in the same order to the queue....

			but we have to update the answer list one time from left to right..

			and the next time from right to left....
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        int k=0;
        q.offer(root);
        List<Integer> h=new ArrayList<>();
        h.add(root.val);
        ans.add(h);
        while(!q.isEmpty())
        {
            List<TreeNode> hld=new ArrayList<>();
            List<Integer> store=new ArrayList<>();
            
            int size=q.size();
            while(!q.isEmpty())
            {
                TreeNode tmp=q.poll();
                
                if(tmp.left!=null) hld.add(tmp.left);
                if(tmp.right!=null) hld.add(tmp.right);
                
            }
            for(TreeNode i : hld)
            {
                q.add(i);
            }
            if(hld.size()==0) continue;
            if(k%2==1)
            {
                for(TreeNode i : hld)
                {
                    store.add(i.val);
                }
            }
            else
            {
                int s=hld.size();
                for(int i=s-1;i>=0;--i)
                {
                    store.add(hld.get(i).val);
                }
            }
            ++k;
            ans.add(store);
        }
        
        return ans;
    }
}