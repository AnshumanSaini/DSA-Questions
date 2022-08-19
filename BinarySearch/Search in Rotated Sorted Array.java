/******************Binary search is used when we have a range of value and we have to find the a value within that range*************/
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
*/

/*
Intution:
			in this we have actually two arrays in asc order, but we don't know from where the both arrays starts...

			so we have to find the target in the first array by making the condition as given follows...

			if the target does not found in the first array we have to find the target in the second array....
*/
class Solution 
{
    public int search(int[] nums, int target) 
    {
        int i=0;
        while(i<nums.length && nums[i]<=target)
        {
            if(nums[i]==target) return i;
            ++i;
        }
        for(int j=nums.length-1;j>=i;--j)
        {
            if(nums[j]==target) return j;
        }
        
        return -1;
    }
}