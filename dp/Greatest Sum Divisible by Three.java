import java.util.*;
/*
 Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

 Input: nums = [3,6,5,1,8]
 Output: 18
 
 Input: nums = [1,2,3,4,4]
 Output: 12
 */
class Solution 
{
    public int solve(int[] nums, int ind,int mod,int[][] dp)
    {
        if(ind==nums.length)
        {
            if(mod==0) return 0;
            else return -100000000;
        }
        
        if(dp[ind][mod]!=-1) return dp[ind][mod];
        
        int take=nums[ind]+solve(nums,ind+1,(mod+nums[ind])%3,dp);
        int not_take=0+solve(nums,ind+1,mod,dp);

        return dp[ind][mod]=Math.max(take,not_take);
    }
    public int maxSumDivThree(int[] nums)
    {
        int[][] dp=new int[nums.length+1][3];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(nums,0,0,dp);
    }
}