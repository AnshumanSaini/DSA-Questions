/*
You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG). The nodes are numbered from 0 to n - 1 (inclusive).

You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge from fromi to toi in the graph.

Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.

A node u is an ancestor of another node v if u can reach v via a set of edges.
*/

import java.util.*;

class Solution 
{
    public void DFS(boolean[] vis, List<Integer> list, HashMap<Integer,List<Integer>> map, int ind, HashMap<Integer,List<Integer>> memo)
    {
        if(vis[ind]) return;
        vis[ind]=true;
        if(memo.containsKey(ind))
        {
            for(Integer k : memo.get(ind))
            {
                list.add(k);
            }
            return;
        }
        list.add(ind);

        for(Integer val : map.get(ind))
        {
            DFS(vis,list,map,val,memo);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) 
    {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        for(int r : edges)
        {
            if(map.containsKey(r[1]))
            {
                map.get(r[1]).add(r[0]);
            }
            else
            {
                List<Integer> list=new ArrayList<>();
                list.add(a[0]);
                map.put(a[1],list);
            }
        }

        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,List<Integer>> memo=new HashMap<>();

        for(int i=0;i<n;++i)
        {
            List<Integer> list=new ArrayList<>();
            boolean[] vis=new boolean[n];
            
            for(Integer j : map.get(i))
            {
                DFS(vis,list,map,j,memo);
            }
            Collections.sort(list);

            ans.add(list);
            memo.put(i,ans);
        }
    }
}