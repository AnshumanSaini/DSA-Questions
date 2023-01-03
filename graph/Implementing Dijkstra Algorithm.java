/*
Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , 
second integers corresponds to the weight of that  edge . 
You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S.
You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 

Note: The Graph doesn't contain any negative weight cycle.
*/

import java.util.*;

class Pair
{
    int dis;
    int node;
    public Pair(int dis, int node)
    {
        this.dis=dis;
        this.node=node;
    }
}
class Solution
{
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.dis-y.dis);
        
        int[] distance=new int[V];
        Arrays.fill(distance, (int)Math.pow(10,9));
        
        pq.add(new Pair(0,S));
        distance[S]=0;
        
        while(!pq.isEmpty())
        {
            int currDis=pq.peek().dis;
            int currNode=pq.poll().node;
            
            for(int i=0;i<adj.get(currNode).size();++i)
            {
                int N=adj.get(currNode).get(i).get(0);
                int D=adj.get(currNode).get(i).get(1);
                
                if(distance[N]>(currDis+D)) 
                {
                    distance[N]=(currDis+D);
                    pq.add(new Pair(distance[N],N));
                }
            }
        }
        
        return distance;
    }
}