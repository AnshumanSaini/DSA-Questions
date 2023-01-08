/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
*/

import java.util.*;

class Solution 
{
    public int maxPoints(int[][] points) 
    {
        int n=points.length;
        if(n<=2) return n;
        int ans=0;
        for(int i=0;i<n;++i)
        {
            for(int j=i+1;j<n;++j)
            {
                int cnt=2;
                for(int k=j+1;k<n;++k)
                {
                    int m1=(points[i][1]-points[j][1])*(points[i][0]-points[k][0]);
                    int m2=(points[i][1]-points[k][1])*(points[i][0]-points[j][0]);
                    if(m1==m2)
                    {
                        ++cnt;
                    }
                }
                //System.out.println(cnt+"...");
                ans=Math.max(ans,cnt);
            }
        }

        return ans;
    }
}