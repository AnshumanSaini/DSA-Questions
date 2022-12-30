/*
You are given an integer n denoting the number of cities in a country. The cities are numbered from 0 to n - 1.

You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.

You need to assign each city with an integer value from 1 to n, where each value can only be used once. The importance of a road is then defined as the sum of the values of the two cities it connects.

Return the maximum total importance of all roads possible after assigning the values optimally.
*/

import java.util.*;

class Solution 
{
    public long maximumImportance(int n, int[][] roads) 
    {
        int[] indegree=new int[n];
        
        for(int[] curr : roads)
        {
            ++indegree[curr[0]];
            ++indegree[curr[1]];
        }

        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;++i)
        {
            list.add(new int[]{i,indegree[i]});
        }

        Collections.sort(list,(a,b) -> a[1]-b[1]);

        for(int[] arr : list)
        {
            System.out.println(arr[0]+" "+arr[1]);
        }

        int[] store=new int[n];
        for(int i=0;i<n;++i)
        {
            store[list.get(i)[0]]=i+1;
        }
        long sum=0;
        for(int[] curr : roads)
        {
            sum+=store[curr[0]]+store[curr[1]];
        }

        return sum;
    }
}