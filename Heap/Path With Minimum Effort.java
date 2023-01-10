/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
*/

import java.util.*;

class Solution 
{
    PriorityQueue<Integer> pq;
    public void solve(int[][] heights, int x, int y, int prex, int prey, int max)
    {
        if(x<0 || x>=heights.length || y<0 || y>=heights[0].length || heights[x][y]==-1) return;

        if(x==heights.length-1 && y==heights[0].length-1)
        {
            max=Math.max(max,Math.abs(heights[x][y]-heights[prex][prey]));
            pq.add(max);
            return;
        }
        int val=heights[x][y];
        heights[x][y]=-1;

        max=Math.max(max,Math.abs(heights[x][y]-heights[prex][prey]));


        solve(heights,x+1,y,x,y,max);
        solve(heights,x-1,y,x,y,max);
        solve(heights,x,y+1,x,y,max);
        solve(heights,x,y-1,x,y,max);
        heights[x][y]=val;

    }
    public int minimumEffortPath(int[][] heights) 
    {
        pq=new PriorityQueue<>();
        solve(heights,0,0,0,0,0);
        return pq.poll();    
    }
}