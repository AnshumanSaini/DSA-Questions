/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
*/

/*
Intution:
			The intution is same as the 3sum intution as here also we are Sorting the array...

			then we are traversing the array and applying the binary search on the rest of the array on the right of the i(th) index...

			just the only difference is that here we are not ignoring the repeated value...
*/

class Solution 
{
    public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;++i)
        {
            int l=i+1;
            int r=n-1;
            while(l<r)
            {
                int sum=nums[i]+nums[l]+nums[r];
                int diff=Math.abs(target-sum);
                if(((int)Math.abs(target-ans))>diff) ans=sum;
                if(sum<target) ++l;
                else
                {
                    if(sum>target)--r;
                    else break;
                }      
            }
        }
        
        return ans;
    }
}