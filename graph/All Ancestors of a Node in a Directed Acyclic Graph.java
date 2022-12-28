/*
You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG). The nodes are numbered from 0 to n - 1 (inclusive).

You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge from fromi to toi in the graph.

Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.

A node u is an ancestor of another node v if u can reach v via a set of edges.
*/

import java.util.*;

class Solution 
{
    public void DFS(List<List<Integer>> ans, List<List<Integer>> tra, int ind, int val)
    {
        for(Integer i : tra.get(ind))
        {
            if(ans.get(i).contains(val)) continue;

            ans.get(i).add(val);
            DFS(ans,tra,i,val);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        List<List<Integer>> tra=new ArrayList<>();

        for(int i=0;i<n;++i)
        {
            ans.add(new ArrayList<>());
            tra.add(new ArrayList<>());
        }

        for(int[] r : edges)
        {
            tra.get(r[0]).add(r[1]);
        }

        for(int i=0;i<n;++i)
        {
            DFS(ans,tra,i,i);
        }

        return ans;
    }
}