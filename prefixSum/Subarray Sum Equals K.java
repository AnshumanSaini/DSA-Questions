/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

/*
Intution:
			we have to store each prev sum from 0 to n in the map...

			for finding the subarray we have to find the subarray sum which will be from starting whose value is equal to sum-prevSum...

			**********************
			*************
						 .........

						 dotted line is the desired subarray sum that is equal to k...
*/

class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int j=0;
        int sum=0;
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;++i)
        {
            sum+=nums[i];
            ans+=map.getOrDefault(sum-k,0);
            //if(sum==k) ++ans;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}