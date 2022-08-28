/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
*/

/*
Intution:
			we have to replace each odd with 1 and replace each even with 0...

			then we have to use the logic of "SUM OF SUBARRAYS EQUALS K"....
*/

class Solution 
{
    public int numberOfSubarrays(int[] nums, int k) 
    {
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]%2==0) nums[i]=0;
            else nums[i]=1;
        }
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        for(int i=0;i<nums.length;++i)
        {
            sum+=nums[i];
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
        
    }
}