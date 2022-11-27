import java.util.*;

/*
You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.
 */

class Solution 
{
    public long totalCost(int[] costs, int k, int candidates) 
    {
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();

        pq1.add(Integer.MAX_VALUE);
        pq2.add(Integer.MAX_VALUE);
        int n=costs.length;
        int r=n-1;
        int l=0;
        
        if(candidates*2>=n)
        {
            int i=0;
            for(;i<candidates;++i) pq1.add(costs[i]);
            l=i+1;
            r=i;
            for(;i<n;++i) pq2.add(costs[i]);
            
        }
        else
        {
            for(;l<candidates;++l,--r)
            {
                pq1.add(costs[l]);
                pq2.add(costs[r]);
            }
        }
        System.out.println(pq1);
        System.out.println(pq2);
        long sum=0;
        while(k!=0)
        {
            if(pq1.peek()==pq2.peek())
            {
                sum+=pq1.peek();
                if(l<=r)
                {
                    if(costs[l]<costs[r])
                    {
                        pq1.poll();
                        pq1.add(costs[l++]);
                    }
                    else
                    {
                        pq2.poll();
                        pq2.add(costs[--r]);
                    }
                }
            }
            else
            {
                if(pq1.peek()<pq2.peek())
                {
                    sum+=pq1.poll();
                    if(l<=r) pq1.add(costs[l++]);
                }
                else
                {
                    sum+=pq2.poll();
                    if(l<=r) pq2.add(costs[r--]);
                }
            }
            --k;
        }

        return sum;
    }
}

/*
[10,1,11,10]
2
1
 */