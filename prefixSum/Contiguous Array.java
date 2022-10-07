/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
*/

/*
Intution:
			same technique as the find the subarray that satisties the given condition (using hashMap, and prefixSum = "subarray sum equals K").....

			we have to maintain the diff pointer that records the number of 1/0 till the ith index....
*/

class Solution 
{
    public int findMaxLength(int[] nums) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int diff=0;
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;++i)
        {
            if(nums[i]==0) --diff;
            else ++diff;
            if(diff==0) ans=Math.max(ans,i+1);
            if(map.containsKey(diff))
            {
                int ind=map.get(diff);
                ans=Math.max(ans,i-ind);
            }
            else map.put(diff,i);
        }

        if(diff==0) return n;
        return ans;
    }
}