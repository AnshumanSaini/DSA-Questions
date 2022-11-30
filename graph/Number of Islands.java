import java.util.LinkedList;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
*/
import java.util.*;

class Solution 
{
    public void DFS(char[][] grid, int x,int y)
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1') return;

        grid[x][y]='.';
        DFS(grid,x-1,y);
        DFS(grid,x+1,y);
        DFS(grid,x,y-1);
        DFS(grid,x,y+1);

    }
    public int numIslands(char[][] grid) 
    {
        int r=grid.length;
        int c=grid[0].length;
        int ans=0;
        for(int i=0;i<r;++i)
        {
            for(int j=0;j<c;++j)
            {
                if(grid[i][j]!='1') continue;
                DFS(grid,i,j);
                ++ans;
            }
        }
        return ans;
    }
}
