import java.util.*;
/*
Given an integer array nums, return the number of all the arithmetic subsequences of nums.

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The test cases are generated so that the answer fits in 32-bit integer.
 */

class Solution 
{
    public int solve(int[] nums, int ind, int prev, int diff)
    {
        if(ind==nums.length) return 0;
        
        int take=0;
        if((nums[ind]-prev)==diff) take=1+solve(nums,ind+1,nums[ind],diff);
        int nottake=solve(nums,ind+1,prev,diff);

        return take+nottake;
    }
    public int numberOfArithmeticSlices(int[] nums) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<3) return 0;
        int sum=0;
        for(int i=0;i<n-2;++i)
        {
            for(int j=i+1;j<n-1;++j)
            {
                int diff=nums[j]-nums[i];
                sum+=solve(nums,j+1,nums[j],diff);
            }
        }
        
        return sum;
    }
}