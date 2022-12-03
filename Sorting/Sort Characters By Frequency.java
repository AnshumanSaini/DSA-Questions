/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
*/

import java.util.*;

class Solution 
{
    public String frequencySort(String s) 
    {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;++i)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }

        int[][] bucket=new int[map.size()][2];
        int k=0;
        for(Map.Entry<Character,Integer> val : map.entrySet())
        {
            bucket[k][0]=val.getKey();
            bucket[k++][1]=val.getValue();
        }
        Arrays.sort(bucket,(a,b) -> (b[1]-a[1]));

        StringBuilder ans=new StringBuilder("");

        for(int i=0;i<bucket.length;++i)
        {
            if(bucket[i][1]==0) break;
            while(bucket[i][1]>0)
            {
                ans.append((char)bucket[i][0]);
                --bucket[i][1];
            }
        }

        return ans.toString();
    }
}