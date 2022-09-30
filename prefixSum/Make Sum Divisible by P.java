/*
Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.
*/

/*
Intution:
			in this we have to maintain the map of the key(the remainder at any point of time) and its length......

			there are two cases i.e. the current remainder and the desired remainder to make the total sum%p==0.....

			refer: https://leetcode.com/problems/make-sum-divisible-by-p/solutions/1066625/java-prefixsum-with-hashmap-with-detailed-explanation-and-comments/
*/

class Solution 
{
    public int minSubarray(int[] nums, int p)
    {
        int n=nums.length;
        long[] pre=new long[n+1];
        for(int i=1;i<=n;++i)
        {
            pre[i]=nums[i-1]+pre[i-1];
        }
        if(pre[n]%p==0) return 0;
        HashMap<Long,Integer> map=new HashMap<>();
        long sum=0;
        map.put(0l,n+1); // mapping of key and length.
        int ans=n;
        for(int i=n;i>=0;--i)
        {
            long rem=pre[i]%p;
            long d_rem=0;
            if(rem!=0) d_rem=p-rem;

            if(map.containsKey(d_rem)) ans=Math.min(ans,map.get(d_rem)-(i+1));

            if(i>0) sum+=nums[i-1];
            map.put(sum%p,i);
        }

        if(ans==n) return -1;
        else return ans;
    }
}

