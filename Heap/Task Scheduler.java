/*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
*/

import java.util.*;

class Solution 
{
    public int leastInterval(char[] tasks, int n) 
    {
        if(n==0) return tasks.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Character,Integer> map=new HashMap<>();

        for(char c : tasks)
        {
            map.put(c,map.getOrDefault(c, 0)+1);
        }

        for(Map.Entry<Character,Integer> val : map.entrySet())
        {
            pq.add(val.getValue());
        }
        
        
        
        Integer[] hld=new Integer[n+1];
        int ans=0;
        while(!pq.isEmpty())
        {
            System.out.println(pq+"...."+ans);
            int cnt=0;
            for(int i=0;i<=n;++i)
            {
                hld[i]=pq.poll();
                if(hld[i]==null) 
                {
                    ++cnt;
                    continue;
                }
                
                --hld[i];
                if(hld[i]==0) ++cnt;
            }
            
            if(cnt==n+1 && pq.isEmpty()) 
            {
                for(int i=0;i<=n;++i) 
                {
                    if(hld[i]==null) continue;
                    if(hld[i]==0) ++ans;
                }

                return ans;
            }

            ans+=(n+1);
            for(int i=0;i<=n;++i)
            {
                System.out.print(hld[i]+" ");
                if(hld[i]==null || hld[i]==0) continue;
                else pq.add(hld[i]);
            }
            System.out.println();
        }
        return -1;
    }
}
