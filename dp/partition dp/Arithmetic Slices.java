/*
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.
 */

class Solution
{
    public int solve(int[] nums, int diff,int prev, int ind)
    {
        if(ind==nums.length || (nums[ind]-prev)!=diff) return 0;

        return 1+ solve(nums,diff,nums[ind],ind+1);
    }
    public int numberOfArithmeticSlices(int[] nums) 
    {
        int n=nums.length;
        if(n<3) return 0;
        int sum=0;
        for(int i=0;i<n-2;++i)
        {
            int diff=nums[i+1]-nums[i];
            sum+=solve(nums,diff,nums[i+1],i+2);
        }

        return sum;
    }
}
// optimized code........
class Solution
{
    public int numberOfArithmeticSlices(int[] nums) 
    {
        int n=nums.length;
        if(n<3) return 0;
        int sum=0;
        for(int i=0;i<n-2;++i)
        {
            //System.out.println(nums[i]+" "+sum);
            int diff=nums[i+1]-nums[i];
            for(int j=i+2;j<n;++j)
            {
                if((nums[j]-nums[j-1])!=diff) break;
                else sum+=1;
            }
        }
        
        return sum;
    }
}