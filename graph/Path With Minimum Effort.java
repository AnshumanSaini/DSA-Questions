/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
*/

import java.util.*;

class Triple
{
    int diff;
    int x;
    int y;
    public Triple(int diff, int x, int y)
    {
        this.diff=diff;
        this.x=x;
        this.y=y;
    }
}

class Solution 
{
    public int minimumEffortPath(int[][] heights) 
    {
        PriorityQueue<Triple> pq=new PriorityQueue<>((a,b) -> a.diff-b.diff);

        int r=heights.length;
        int c=heights[0].length;

        int[][] dis=new int[r][c];
        for(int[] row : dis)
        {
            Arrays.fill(row, (int)Math.pow(10,9));
        }

        dis[0][0]=0;
        int[] dr=new int[]{1,0,-1,0};
        int[] dc=new int[]{0,-1,0,1};

        pq.add(new Triple(0, 0, 0));
        while(!pq.isEmpty())
        {
            Triple hld=pq.poll();
            int currDiff=hld.diff;
            int currX=hld.x;
            int currY=hld.y;

            for(int i=0;i<4;++i)
            {
                int x=currX+dr[i];
                int y=currY+dc[i];

                if(x<0 || x>=heights.length || y<0 || y>=heights[0].length) continue;
                int diff=Math.max(currDiff, Math.abs(heights[currX][currY]-heights[x][y]));

                if(dis[x][y]>diff)
                {
                    dis[x][y]=diff;
                    pq.add(new Triple(diff, x, y));
                }
            }
        }

        return dis[r-1][c-1];
    }
}