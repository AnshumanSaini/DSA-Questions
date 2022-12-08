/*
You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.

Return the number of steps performed until nums becomes a non-decreasing array.

Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
Output: 3

Input: nums = [4,5,7,7,13]
Output: 0
*/
import java.util.*;
class Pair
{
    int key;
    int cnt;
    public Pair(int key, int cnt)
    {
        this.key=key;
        this.cnt=cnt;
    }
}
class Solution 
{
    public int totalSteps(int[] nums) 
    {
        int ans=0;
        Stack<Pair> stk=new Stack<>();
        int n=nums.length;
        stk.add(new Pair(nums[n-1],0));
        for(int i=n-2;i>=0;--i)
        {
            if(stk.peek().key>=nums[i]) stk.add(new Pair(nums[i],0));
            else
            {
                int cnt=0;
                while(!stk.isEmpty() && stk.peek().key<nums[i])
                {
                    ++cnt;
                    Pair tmp=stk.pop();
                    cnt=Math.max(cnt,tmp.cnt);
                }
                stk.add(new Pair(nums[i],cnt));
                ans=Math.max(cnt,ans);
            }
        }
        
        return ans;
    }
}