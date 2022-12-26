/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.

*/

import java.util.*;

class Solution 
{
    public boolean DFS(List<List<Integer>> adj, int V, int ind, boolean[] vis, boolean[] fvis)
    {
        if(vis[ind]==true)
        {
            for(int i=0;i<V;++i)
            {
                if(vis[i]==true) fvis[i]=true;
            }

            return false;
        }

        vis[ind]=true;
        for(Integer i : adj.get(ind))
        {
            if(!DFS(adj,V,i,vis,fvis)) return false;
        }
        vis[ind]=false;
        return true;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) 
    {
        List<Integer> ans=new ArrayList<>();
        boolean[] fvis=new boolean[V];

        for(int i=0;i<V;++i)
        {
            if(fvis[i]==true) continue;
            boolean[] vis=new boolean[V];
            if(DFS(adj,V,i,vis,fvis)) ans.add(i);
        }

        return ans;
    }
}