/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
*/

import java.util.*;

class Solution 
{
    public String reorganizeString(String s) 
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> (b[1]-a[1]));
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();++i)
        {
            int ch=(int)s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Integer,Integer> val : map.entrySet())
        {
            pq.add(new int[]{val.getKey(),val.getValue()});
        }
        StringBuilder ans=new StringBuilder("");
        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            if(pq.isEmpty() && curr[1]>1) return "";
            ans.append((char)curr[0]);
            if(pq.isEmpty() && curr[1]==1) break;
            else
            {
                int[] curr2=pq.poll();
                ans.append((char)curr2[0]);
                if(curr[1]>1) pq.add(new int[]{curr[0],curr[1]-1});
                if(curr2[1]>1) pq.add(new int[]{curr2[0],curr2[1]-1});
            }
        }

        return ans.toString();
    }
}
