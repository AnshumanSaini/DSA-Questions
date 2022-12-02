/*
There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.

Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.

Note that node 0 will not be a restricted node.

Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
Output: 4
*/
import java.util.*;

class Solution 
{
    int ans;
    public void DFS(HashMap<Integer,Set<Integer>> map, int ind, Set<Integer> set)
    {
        if(set.contains(ind)) return;
        set.add(ind);
        ++ans;
        for(Integer i : map.get(ind))
        {
            DFS(map, i, set);
        }
        
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) 
    {
        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        for(int[] r : edges)
        {
            if(map.containsKey(r[0]))
            {
                map.get(r[0]).add(r[1]);
            }
            else
            {
                Set<Integer> set=new HashSet<>();
                set.add(r[1]);
                map.put(r[0], set)
            }
            
            if(map.containsKey(r[1]))
            {
                map.get(r[1]).add(r[0]);
            }
            else
            {
                Set<Integer> set=new HashSet<>();
                set.add(r[0]);
                map.put(r[1], set)
            }
        }
        Set<Integer> set=new HashSet<>();

        for(int i : restricted) set.add(i);
        ans=0;
        DFS(map, 0, set);
        return ans;
    }
}
