/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/

import java.util.*;

class Solution 
{
    public void DFS(int[][] grid, int i, int j, int min)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || (grid[i][j]<min && grid[i][j]>1)) return;
        grid[i][j]=min;
        DFS(grid, i+1, j, min+1);
        DFS(grid, i-1, j, min+1);
        DFS(grid, i, j-1, min+1);
        DFS(grid, i, j+1, min+1);

    }
    public int orangesRotting(int[][] grid) 
    {
        int row=grid.length;
        int col=grid[0].length;
        
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j]==2)
                {
                    DFS(grid,i,j,2);
                }
            }
        }
        int ans=2;
        for(int i=0;i<row;++i)
        {
            for(int j=0;j<col;++j)
            {
                if(grid[i][j]==0) continue;
                if(grid[i][j]==1) return -1;
                else
                {
                    ans=Math.max(ans,grid[i][j]);
                }
            }
        }
        
        return ans-2;
    }
}