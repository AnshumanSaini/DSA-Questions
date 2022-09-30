/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
*/

/*
Intution:
			let Si=a1+a2+a3...+ai.
			and Sj=a1+a2+a3...+aj;
			ri=Si%k;
			rj=Sj%k;

			so, if ri==rj then the subarray is divisible by k(the desired subarray)....

			refer: https://leetcode.com/problems/subarray-sums-divisible-by-k/solutions/413234/detailed-whiteboard-beats-100-do-you-really-want-to-understand-it/
*/

/*
class Solution 
{
    public int subarraysDivByK(int[] nums, int k) 
    {
        int sum=0;
        int ans=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i : nums)
        {
            sum=(sum+i)%k;
            if(sum<0) sum+=k;

            ans+=map.getOrDefault(sum,0);

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return ans;
    }    
}
*/