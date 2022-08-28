/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/

/*
Intution:
			i am taking the pointer f that store the occurence of zero if if the zero occur then we will put j to f+1.....

			and we keep on storing the length of the string containing only one zero...
*/

class Solution 
{
    public int longestSubarray(int[] nums) 
    {
        int f=-1;
        int j=0;
        int ans=0;
        
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]==0)
            {
                j=f+1;
                f=i;
            }
            if(f!=-1)
            {
                ans=Math.max(ans,i-j);
            }
            else ans=Math.max(ans,i-j+1);
        }
        if(f==-1) ans-=1;
        return ans;
    }
}