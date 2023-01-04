/*
You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.

Example:
Input:
n = 5, m= 6
edges = [[1,2,2], [2,5,5], [2,3,4], [1,4,1],[4,3,3],[3,5,1]]
Output:
1 4 3 5
Explaination:
Shortest path from 1 to n is by the path 1 4 3 5
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
    public static List<Integer> shortestPath(int n, int m, int edges[][]) 
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> (x.dis-y.dis));
        int[] parent=new int[n+1];
        int[] dis=new int[n+1];

        List<List<Pair>> list=new ArrayList<>();
        for(int i=0;i<=n;++i)
        {
            list.add(new ArrayList<Pair>());
        }

        for(int[] r : edges)
        {
            list.get(r[0]).add(new Pair(r[2], r[1]));
            list.get(r[1]).add(new Pair(r[2], r[0]));
        }
        
        for(int i=1;i<=n;i++)
        {
            dis[i]=(int)Math.pow(10,9);
            parent[i]=i;
        }
        dis[1]=0;
        pq.add(new Pair(dis[1], 1));
        while(!pq.isEmpty())
        {
            Pair hld=pq.poll();
            int currNode=hld.node;
            int currDis=hld.dis;

            for(int i=0;i<list.get(currNode).size();++i)
            {
                int N=list.get(currNode).get(i).node;
                int D=list.get(currNode).get(i).dis;

                if(dis[N]>dis[currNode]+D)
                {
                    dis[N]=dis[currNode]+D;
                    parent[N]=currNode;
                    pq.add(new Pair(dis[N],N));
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        if(dis[n]==(int)Math.pow(10,9))
        {
            ans.add(-1);
            return ans;
        }
        int Node=n;
        while(parent[Node]!=Node)
        {
            ans.add(Node);
            Node=parent[Node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}