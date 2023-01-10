/*
Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: If the Graph contains a negative cycle then return an array consisting of only -1.
*/

import java.util.*;

class Solution 
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) 
    {
        int max=100000000;
        int[] dis=new int[V];
        Arrays.fill(dis, (int)Math.pow(10,8));

        dis[S]=0;

        for(int i=0;i<V-1;++i)
        {
            for(ArrayList<Integer> val : edges)
            {
                int u=val.get(0);
                int v=val.get(1);
                int wt=val.get(2);

                if(dis[u]!=max && dis[v]>(dis[u]+wt))
                {
                    dis[v]=dis[u]+wt;
                }
            }
        }

        for(ArrayList<Integer> val : edges)
        {
            int u=val.get(0);
            int v=val.get(1);
            int wt=val.get(2);

            if(dis[u]!=max && dis[v]>(dis[u]+wt))
            {
                int[] temp=new int[1];
                temp[0]=-1;
                return temp;
            }
        }

        return dis;
    }
}

