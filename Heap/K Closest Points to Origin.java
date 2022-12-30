/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/

import java.util.*;

class Solution 
{
    public int[][] kClosest(int[][] points, int k) 
    {
        List<double[]> list=new ArrayList<>();

        for(int i=0;i<points.length;++i)
        {
            double[] tra=new double[2];
            tra[0]=i;
            tra[1]=Math.sqrt(Math.pow((double)points[i][0],2)+Math.pow((double)points[i][1], 2));
            list.add(tra);
        }

        Collections.sort(list,(a,b) -> Double.compare(a[1], b[1]));

        int[][] ans=new int[k][2];
        for(double[] curr : list)
        {
            System.out.println(curr[0]+" "+curr[1]);
        }
        for(int i=0;i<k;++i)
        {
            double[] curr=list.get(i);

            ans[i][0]=points[(int)curr[0]][0];
            ans[i][1]=points[(int)curr[0]][1];
        }

        return ans;
    }
}