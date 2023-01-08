/*
Given a n * m matrix grid where each element can either be 0 or 1. You need to find the shortest distance between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1. 

If the path is not possible between source cell and destination cell, then return -1.

Note : You can move into an adjacent cell if that adjacent cell is filled with element 1. Two cells are adjacent if they share a side. In other words, you can move in one of the four directions, Up, Down, Left and Right.

Note: 
1. we will be using Queue insted of Priority Queue because all the four directions will be having same distance and the sorting will make no difference.
2. Now once we get the destination coordinates we will stop,  because that will be the shortest distance.
*/

import java.util.*;

class Triple
{
    int dis;
    int x;
    int y;
    public Triple(int dis, int x, int y)
    {
        this.dis=dis;
        this.x=x;
        this.y=y;
    }
}

class Solution 
{
    int shortestPath(int[][] grid, int[] source, int[] destination) 
    {
        Queue<Triple> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;

        if(source[0]==destination[0] && source[1]==destination[1]) return 0;
        
        int[][] dis=new int[n][m];
        for(int[] r : dis)
        {
            Arrays.fill(r, (int)Math.pow(10,9));
        }

        dis[source[0]][source[1]]=0;
        q.add(new Triple(0, source[0], source[1]));
        
        int[] dr=new int[]{0,1,0,-1};
        int[] dc=new int[]{1,0,-1,0};
        
        while(!q.isEmpty())
        {
            Triple hld=q.poll();
            
            int currDis=hld.dis;
            int currX=hld.x;
            int currY=hld.y;

            for(int i=0;i<4;++i)
            {
                int x=currX+dr[i];
                int y=currY+dc[i];

                if(x>=grid.length || y>=grid[0].length || x<0 || y<0 || grid[x][y]==0) continue;

                if(dis[x][y]>(1+currDis))
                {
                    dis[x][y]=1+currDis;
                    if(x==destination[0] && y==destination[1]) return dis[x][y];
                    q.add(new Triple(dis[x][y], x, y));
                }
            }
        }
        
        return -1;
    }
}
