/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
*/

/*
Intution:
			the approach is same as the approach of finding the cycle in the Linked List......
*/

class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        int slow=nums[0];
        int fast=nums[0];
        do
        {
            fast=nums[nums[fast]];
            slow=nums[slow];
        }
        while(fast!=slow);
        
        slow=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        
        return fast;
    }
}