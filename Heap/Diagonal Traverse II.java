/*
Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
*/

import java.util.*;

class Solution 
{
    public int[] findDiagonalOrder(List<List<Integer>> nums) 
    {
        Queue<int[]> q=new LinkedList<>();

        q.add(new int[]{0,0});
        List<Integer> list=new ArrayList<>();
        list.add(nums.get(0).get(0));
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;++i)
            {
                int[] curr=q.poll();
                if(i==0)
                {
                    if(curr[0]+1<nums.size() && curr[1]<nums.get(curr[0]+1).size())
                    {
                        q.add(new int[]{curr[0]+1,curr[1]});
                        list.add(nums.get(curr[0]+1).get(curr[1]));
                    }
                }
                if(curr[0]<nums.size() && curr[1]+1<nums.get(curr[0]).size())
                {
                    q.add(new int[]{curr[0],curr[1]+1});
                    list.add(nums.get(curr[0]).get(curr[1]+1));
                }
            }
        }

        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();++i)
        {
            ans[i]=list.get(i);
        }

        return ans;
    }
}