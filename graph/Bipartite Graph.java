/*
Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
*/

import java.util.*;

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] arr=new int[V];
        Arrays.fill(arr, -1);
        
        for(int v=0;v<V;++v)
        {
            if(arr[v]==-1)
            {
                Queue<Integer> q=new LinkedList<>();
                
                arr[v]=0;
                q.add(v);
                while(!q.isEmpty())
                {
                    Integer hld=q.poll();
                    
                    for(Integer i : adj.get(hld))
                    {
                        
                        if(arr[i]==-1)
                        {
                            arr[i]=arr[hld]^1;
                            q.add(i);
                        }
                        else
                        {
                            if(arr[i]==arr[hld]) return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}