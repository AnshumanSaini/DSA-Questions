/*
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i, 0<=i

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

 

Example:

Input:
n = 6, m= 7
edge=[[0,1,2],[0,4,1],[4,5,4]
,[4,2,2],[1,2,3],[2,3,6],[5,3,1]]

Output:
0 2 3 6 1 5
*/

/*
Steps: 
1: Do a Topological Sorting using DFS | Stack
2: Create a Distance Array
3: And keep poping elements from stack and relax every node.
*/

import java.util.*;

class Solution 
{
    public void topo(boolean[] vis, List<List<int[]>> list, Stack<Integer> stk, int ind)
    {
        if(vis[ind]) return;
        vis[ind]=true;
        for(int[] val : list.get(ind))
        {
            if(!vis[val[0]]) topo(vis,list,stk,val[0]);
        }
        stk.add(ind);
    }

	public int[] shortestPath(int N,int M, int[][] edges) 
	{
	    boolean[] vis=new boolean[N];
	    
	    List<List<int[]>> list=new ArrayList<>();
	    
	    for(int i=0;i<N;++i)
	    {
	        List<int[]> tmp=new ArrayList<>();
	        list.add(tmp);
	    }
	    
	    for(int[] r : edges)
	    {
	        list.get(r[0]).add(new int[]{r[1],r[2]});
	    }
	    
	    Stack<Integer> stk=new Stack<>();
	    for(int i=0;i<N;++i)
	    {
	        if(!vis[i])
	        {
	            topo(vis,list,stk,i);
	        }
	    }
	    int[] dis=new int[N];
	    Arrays.fill(dis, 1000000007);
	    dis[0]=0;
	    
	    while(!stk.isEmpty())
	    {
	        int curr=stk.pop();
	        
	        for(int[] val : list.get(curr))
	        {
	            if(dis[val[0]]>val[1]+dis[curr]) dis[val[0]]=val[1]+dis[curr];
	        }
	    }
	    
	    for(int i=0;i<N;++i) if(dis[i]==1000000007) dis[i]=-1;
	    
	    return dis;
	    
	}
}