/*
 Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

 Input: nums = [3,6,5,1,8]
 Output: 18
 
 Input: nums = [1,2,3,4,4]
 Output: 12
 */
class Solution 
{
    public int solve(int[] nums, int ind)
    {
        if(ind==nums.length)
        {
            
        }
        int take=nums[ind]+solve(nums,ind+1);
        int not_take=0+solve(nums,ind+1);

        return Math.max(take,not_take);
    }
    public int maxSumDivThree(int[] nums)
    {
        Arrays.sort(nums);
        return solve(nums,0);
    }
}