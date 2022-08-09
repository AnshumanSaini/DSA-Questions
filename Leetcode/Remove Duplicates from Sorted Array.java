/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

/*Intution:
				we have to focus on the undesired subarray rather than the desired subarray...

				because the desired subarray will always start from the begning, so it easy that way...
*/
class Solution 
{
    public int subarraySum(int[] arr, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int sum=0;
        for(int i=0;i<arr.length;++i)
        {
            sum+=arr[i];
            if(map.containsKey(sum-k))
            {
                ans=ans+(map.get(sum-k));
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return ans;
    }
}