// this algorithm is used for topological sorting in the graph.....


import java.util.*;

class Solution
{
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree=new int[V];
        
        for(List<Integer> l : adj)
        {
            for(Integer i : l)
            {
                ++indegree[i];
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;++i)
        {
            if(indegree[i]==0) q.add(i);
        }
        int[] ans=new int[V];
        int k=0;
        while(!q.isEmpty())
        {
            int hld=q.poll();
            ans[k++]=hld;
            
            for(Integer val : adj.get(hld))
            {
                --indegree[val];
                if(indegree[val]==0) q.add(val);
            }
        }
        
        return ans;
    }
}