/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
*/

/*
Intution:
			we can easily go to our child node from any node x, but it is difficlut to go to the parent node....

			so to solve that problem we have to make a map that store the parent and child relation,i.e. for every node x we have to store its parent (map<Child,Parent>)...

			now use queue and implemet the BFS traversal, and also store the parent node of the ith node along with its left and right child....

			and increment the cnt and if the cnt==k put all the entries of the q into the ans list...
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
    public void dfs(HashMap<TreeNode,TreeNode> hm,TreeNode root,TreeNode par)
    {
        if(root==null) return;
        
        
        hm.put(root,par);
        
        dfs(hm,root.left,root);
        dfs(hm,root.right,root);
        
    }
    
    public void solvedfs(TreeNode tar, int k, List<Integer> ans,HashMap<TreeNode,TreeNode> map)
    {
        Set<Integer> vis=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(tar);
        vis.add(tar.val);
        
        int cnt=0;
        
        while(!q.isEmpty())
        {
            //System.out.println(q.size());
            if(k==cnt)
            {
                
                for(int i=q.size()-1;i>=0;--i)
                {
                    //System.out.println("........");
                    ans.add(q.poll().val);
                }
                return;
            }
            else
            {
                for(int i=q.size()-1;i>=0;--i)
                {
                    
                    TreeNode root=q.poll();
                    if(root.left!=null && !vis.contains(root.left.val))
                    {
                        //System.out.println(root.left.val);
                        q.add(root.left);
                        vis.add(root.val);
                    }
                    if(root.right!=null && !vis.contains(root.right.val))
                    {
                        //System.out.println(root.right.val);
                        q.add(root.right);
                        vis.add(root.val);
                    }
                    TreeNode par=map.get(root);
                
                    if(par!=null && !vis.contains(par.val))
                    {
                        //System.out.println(par.val);
                        q.add(par);
                        vis.add(root.val);
                    }
                }
                //System.out.println(q.size());
            }
            ++cnt;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        HashMap<TreeNode,TreeNode> hm=new HashMap<>();
        dfs(hm,root,null);
        
        //print(hm);
        List<Integer> ans=new ArrayList<>();
        solvedfs(target,k,ans,hm);
        return ans;
    }
}