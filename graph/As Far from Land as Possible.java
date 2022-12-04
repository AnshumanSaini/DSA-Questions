/*
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
*/

import java.util.*;

class Solution 
{
    public int maxDistance(int[][] grid) 
    {
        int[][] ways=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;++i)
        {
            for(int j=0;j<grid[0].length;++j)
            {
                if(grid[i][j]==1) q.add(new int[]{i,j});
            }
        }
        int ans=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;++i)
            {
                int[] curr=q.poll();
                for(int[] way : ways)
                {
                    int x=curr[0]+way[0];
                    int y=curr[1]+way[1];
                    if(x>=0 && x<grid.length && y>=0 && y<grid.length && grid[x][y]==0)
                    {
                        grid[x][y]=2;
                        q.add(new int[]{x,y});
                    }
                }
            }
            ++ans;
        }
        
        if(ans==1) return -1;
        else return ans-1;
    }
}
