/*
You are given an Undirected Graph having unit weight, Find the shortest path from src(0) to all the vertex and if it is unreachable to reach any vertex, then return -1 for that vertex.

Example:

Input:
n = 9, m= 10
edges=[[0,1],[0,3],[3,4],[4 ,5]
,[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]] 
src=0
Output:
0 1 2 1 2 3 3 4 4
*/

import java.util.*;

class Solution 
{
    public int[] shortestPath(int[][] edges,int n,int m ,int src) 
    {
        int[] dis=new int[n];
        Arrays.fill(dis, 1000000007);
        
        List<List<Integer>> list=new ArrayList<>();
        
        for(int i=0;i<n;++i)
        {
            list.add(new ArrayList<Integer>());
        }
        for(int[] v : edges)
        {
            list.get(v[0]).add(v[1]);
            list.get(v[1]).add(v[0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        q.add(src);
        dis[src]=0;
        
        while(!q.isEmpty())
        {
            int curr=q.poll();
            for(Integer i : list.get(curr))
            {
                if(dis[i]>(dis[curr]+1))
                {
                    dis[i]=dis[curr]+1;
                    q.add(i);
                }
            }
        }
        
        for(int i=0;i<n;++i)
        {
            if(dis[i]==1000000007) dis[i]=-1;
        }
        
        return dis;
    }
}