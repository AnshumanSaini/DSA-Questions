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
    public void DFS(int[][] matrix, int ind, Set<Integer> set)
    {
        if(set.contains(ind)) return;
        set.add(ind);
        ++ans;
        for(int i=0;i<matrix[ind].length;++i)
        {
            if(matrix[ind][i]==1)
            {
                DFS(matrix, i, set);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) 
    {
        int[][] matrix=new int[n][n];
        
        for(int[] r : edges)
        {
            matrix[r[0]][r[1]]=1;
            matrix[r[1]][r[0]]=1;
        }
        
        Set<Integer> set=new HashSet<>();

        for(int i : restricted) set.add(i);
        ans=0;
        DFS(matrix,0,set);
        return ans;
    }
}
