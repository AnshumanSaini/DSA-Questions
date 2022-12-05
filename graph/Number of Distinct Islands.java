/*
Given a boolean 2D matrix grid of size n * m. 
You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. 
Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).
*/

/*
Intution:
        we can store each island pattern in set and then can return the size of set.....

        To store a pattern, we will store the distance of each node from the base node in each pattern......
*/

import java.util.*;

class Solution 
{
    public void DFS(int[][] grid, int i, int j, boolean[][] vis, ArrayList<String> list, int bi, int bj)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]==true || grid[i][j]==0) return;
        
        vis[i][j]=true;
        list.add((bi-i)+""+(bj-j));
        DFS(grid, i+1, j, vis, list, bi, bj);
        DFS(grid, i-1, j, vis, list, bi, bj);
        DFS(grid, i, j+1, vis, list, bi, bj);
        DFS(grid, i, j-1, vis, list, bi, bj);
    }

    int countDistinctIslands(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        Set<ArrayList<String>> set=new HashSet<>();
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<m;++j)
            {
                if(grid[i][j]==1 && vis[i][j]==false)
                {
                    ArrayList<String> list=new ArrayList<>();
                    DFS(grid,i,j,vis,list, i, j);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
}