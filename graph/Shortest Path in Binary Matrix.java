/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Input: grid = [[0,1],[1,0]]
Output: 2

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
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
    public int shortestPathBinaryMatrix(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1) return -1;
        if(n==1 && m==1) return 1;
        int [][] dis=new int[n][m];
        Queue<Triple> q=new LinkedList<>();
        for(int[] r : dis)
        {
            Arrays.fill(r, (int)Math.pow(10,9));
        }
        dis[0][0]=0;
        q.add(new Triple(0, 0, 0));
        int[] dr=new int[]{-1,0,0,1,-1,-1,1,1};
        int[] dc=new int[]{0,1,-1,0,-1,1,-1,1};
        while(!q.isEmpty())
        {
            Triple hld=q.poll();
            int currDis=hld.dis;
            int currX=hld.x;
            int currY=hld.y;

            for(int i=0;i<8;++i)
            {
                int x=currX+dr[i];
                int y=currY+dc[i];

                if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==1) continue;

                if(dis[x][y]>(currDis+1))
                {
                    dis[x][y]=currDis+1;
                    if(x==n-1 && y==m-1) return dis[x][y]+1;
                    q.add(new Triple(dis[x][y], x, y));
                }
            }
        }

        return -1;
    }
}
