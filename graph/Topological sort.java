/*
Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
*/

import java.util.*;

class Solution
{
    static void DFS(int V,ArrayList<ArrayList<Integer>> adj,boolean[] vis, Stack<Integer> ans, int ind)
    {
        if(vis[ind]==true) return;
        
        vis[ind]=true;
        for(int i : adj.get(ind))
        {
            if(vis[i]!=true) DFS(V,adj,vis,ans,i);
        }
        ans.push(ind);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> ans=new Stack<>();
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;++i)
        {
            if(vis[i]!=true)
            {
                DFS(V,adj,vis,ans,i);
            }
        }
        //System.out.println(ans);
        int[] result=new int[ans.size()];
        
        for(int i=0;!ans.isEmpty() && i<V;++i)
        {
            result[i]=ans.pop();
        }
        
        return result;
    }
}