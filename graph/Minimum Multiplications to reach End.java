/*
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 6 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175
*/

import java.util.*;

class Pair
{
    int node;
    int distance;
    public Pair(int node, int distance)
    {
        this.node=node;
        this.distance=distance;
    }
}

class Solution 
{
    int minimumMultiplications(int[] arr, int start, int end) 
    {
        Queue<Pair> q=new LinkedList<>();

        int[] dis=new int[100000];
        Arrays.fill(dis, (int)Math.pow(10,9));

        q.add(new Pair(start, 0));
        dis[start]=0;

        while(!q.isEmpty())
        {
            Pair hld=q.poll();
            int currNode=hld.node;
            int currDis=hld.distance;

            for(int i=0;i<arr.length;++i)
            {
                int n=currNode*arr[i];
                n=n%100000;
                if(dis[n]>(currDis+1))
                {
                    dis[n]=currDis+1;
                    q.add(new Pair(n, dis[n]));
                }
            }
        }
        if(dis[end]==(int)Math.pow(10,9)) return -1;
        return dis[end];
    }
}
