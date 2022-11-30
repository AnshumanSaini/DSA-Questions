/*
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.
*/
import java.util.*;

class Solution 
{
    int val;
    public void DFS(int[][] grid1, int[][] grid2, int i ,int j)
    {
        if(i<0 || i>=grid1.length || j<0 || j>=grid1[0].length || grid2[i][j]!=1) return;
        if(grid1[i][j]!=1) val=0;
        grid2[i][j]=2;
        DFS(grid1, grid2, i+1, j);
        DFS(grid1, grid2, i-1, j);
        DFS(grid1, grid2, i, j-1);
        DFS(grid1, grid2, i, j+1);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) 
    {
        int r=grid1.length;
        int c=grid1[0].length;
        
        int ans=0;
        for(int i=0;i<r;++i)
        {
            for(int j=0;j<c;++j)
            {
                val=1;
                if(grid2[i][j]!=1) continue;
                DFS(grid1,grid2,i,j);
                ans+=val;
            }
        }

        return ans;
    }
}