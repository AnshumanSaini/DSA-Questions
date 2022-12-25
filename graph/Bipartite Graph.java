/*
Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
*/

import java.util.*;

class Solution
{
    
    public boolean DFS(int[] arr, int V, ArrayList<ArrayList<Integer>> adj, int ind)
    {
        for(Integer i : adj.get(ind))
        {
            if(arr[i]==-1)
            {
                arr[i]=arr[ind]^1;
                if(!DFS(arr,V,adj,i)) return false;
            }
            else
            {
                if(arr[i]==arr[ind]) return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] arr=new int[V];
        Arrays.fill(arr, -1);
        
        for(int v=0;v<V;++v)
        {
            if(arr[v]==-1)
            {
                arr[v]=0;
                if(!DFS(arr,V,adj,v)) return false;
            }
        }
        
        return true;
        
        /*for(int v=0;v<V;++v)
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
        
        */
    }
}