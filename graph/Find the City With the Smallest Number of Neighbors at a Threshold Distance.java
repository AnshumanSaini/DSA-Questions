/*
There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
*/

import java.util.*;

class Solution 
{
    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {
        int[][] dis=new int[n][n];
        for(int[] r : dis)
        {
            Arrays.fill(r, (int)Math.pow(10,9));
        }
        for(int[] r : edges)
        {
            dis[r[0]][r[1]]=r[2];
            dis[r[1]][r[0]]=r[2];
        }
        for(int i=0;i<n;++i)
        {
            dis[i][i]=0;
        }
        
        for(int via=0;via<n;++via)
        {
            for(int i=0;i<n;++i)
            {
                for(int j=0;j<n;++j)
                {
                    dis[i][j]=Math.min(dis[i][j],dis[i][via]+dis[via][j]);
                }
            }
        }

        int node=0;
        int mincnt=(int)Math.pow(10,9);

        for(int i=0;i<n;++i)
        {
            int cnt=0;
            for(int j=0;j<n;++j)
            {
                if(dis[i][j]!=(int)Math.pow(10,9) && dis[i][j]<=distanceThreshold)
                {
                    ++cnt;
                }
            }

            if(cnt<=mincnt)
            {
                mincnt=cnt;
                node=i;
            }
        }

        return node;

    }
}