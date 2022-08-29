/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
*/

/*
Intution:
			we have to remove the elements from the array till we find the immediate previous occurence of the same element...

			and store the ans as maximum of the previous sum and the deleted sum...

			but we have to continue with the new deleted sum....
*/

class Solution 
{
    public int maximumUniqueSubarray(int[] nums) 
    {
        HashSet<Integer> set=new HashSet<>();
        int j=0;
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;++i)
        {
            while(set.contains(nums[i]))
            {
                set.remove(nums[j]);
                sum-=nums[j];
                ++j;
            }
            sum+=nums[i];
            set.add(nums[i]);
            ans=Math.max(ans,sum);
        }
        
        return ans;
    }
}