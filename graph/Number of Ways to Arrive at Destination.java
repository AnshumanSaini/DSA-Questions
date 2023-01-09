/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
Output: 4
Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
The four ways to get there in 7 minutes are:
- 0 ➝ 6
- 0 ➝ 4 ➝ 6
- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
Example 2:

Input: n = 2, roads = [[1,0,10]]
Output: 1
Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
*/

import java.util.*;

class Pair
{
    int node;
    long time;

    public Pair(int node, long time)
    {
        this.node=node;
        this.time=time;
    }
}

class Solution 
{
    public int countPaths(int n, int[][] roads) 
    {
        int mod=1000000007;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.time,b.time));
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=roads.length;++i)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] r : roads)
        {
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }
        int[] count=new int[n+1];
        long[] dis=new long[n+1];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0]=0;
        count[0]=1;
        //int ans=1;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty())
        {
            Pair hld=pq.poll();
            int currNode=hld.node;
            long currTime=hld.time;

            for(int i=0;i<adj.get(currNode).size();++i)
            {
                int nod=adj.get(currNode).get(i).node;
                long t=adj.get(currNode).get(i).time;
                if(dis[nod]>(currTime+t))
                {
                    dis[nod]=currTime+t;
                    count[nod]=count[currNode];
                    pq.add(new Pair(nod, dis[nod]));
                }
                else
                {
                    if(dis[nod]==(currTime+t))
                    {
                        count[nod]=(count[nod]+count[currNode])%mod;
                    }
                }
            }
        }
        //System.out.println(dis[n-1]);
        return count[n-1]%mod;
    }
}