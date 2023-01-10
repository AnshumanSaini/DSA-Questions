/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
*/

import java.util.*;

class Triple
{
    int price;
    int node;
    int stops;
    public Triple(int price, int node, int stops)
    {
        this.price=price; 
        this.node=node;
        this.stops=stops;
    }
}

class Solution 
{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        PriorityQueue<Triple> pq=new PriorityQueue<>((a,b) -> b.price-a.price);
        int size=flights.length;
        int[] dis=new int[n+1];
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=size;++i) adj.add(new ArrayList<>());
        for(int[] r : flights)
        {
            adj.get(r[0]).add(new int[]{r[1],r[2]});
        }

        Arrays.fill(dis, (int)Math.pow(10,9));

        dis[src]=0;
        pq.add(new Triple(0, src, 0));

        while(!pq.isEmpty())
        {
            Triple hld=pq.poll();
            int currPrice=hld.price;
            int currNode=hld.node;
            int currStops=hld.stops;
            if(currStops>k) continue;
            for(int i=0;i<adj.get(currNode).size();++i)
            {
                int[] arr=adj.get(currNode).get(i);
                if(dis[arr[0]]>(currPrice+arr[1]))
                {
                    dis[arr[0]]=currPrice+arr[1];
                    pq.add(new Triple(dis[arr[0]], arr[0], currStops+1));
                }
            }
        }
        if(dis[dst]==(int)Math.pow(10,9)) return -1;
        return dis[dst];
    }
}