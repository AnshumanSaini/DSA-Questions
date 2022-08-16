/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
*/

/*
Intution: 
			[4,5,0,-2,-3,1]
			 *****
			if the remainder of the above highlighted sum of numbers is x i.e     (sum1=kn+x) and

			[4,5,0,-2,-3,1]
			 ********

			and the remainder of the above highlighted sum of numbers is y i.e    (sum2=km+y) 

			so if we subtract the sum1 and sum2 we get-->

			sum1-sum2=k(n-m) 

			which is divisible by k....
*/

class Solution 
{
    public int subarraysDivByK(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int sum=0;
        map.put(0,1);
        int ans=0;
        for(int i : nums)
        {
            sum=(sum+i)%k;
            if(sum<0) sum+=k;
            if(map.containsKey(sum))
            {
                ans+=map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}