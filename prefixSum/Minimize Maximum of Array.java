/*
 You are given a 0-indexed array nums comprising of n non-negative integers.

In one operation, you must:

Choose an integer i such that 1 <= i < n and nums[i] > 0.
Decrease nums[i] by 1.
Increase nums[i - 1] by 1.
Return the minimum possible value of the maximum integer of nums after performing any number of operations.
 */
class Solution 
{
    public int minimizeArrayValue(int[] nums) 
    {
        double sum=0;
        int ans=0;
        for(int i=0;i<nums.length;++i)
        {
            sum+=nums[i];
            ans=(int)Math.max(ans,Math.ceil((double)sum/(double)(i+1)));
        }
        return ans;
    }
}