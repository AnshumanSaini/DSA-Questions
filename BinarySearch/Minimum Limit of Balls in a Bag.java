/******************Binary search is used when we have a range of value and we have to find the a value within that range*************/
/*
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Return the minimum possible penalty after performing the operations.
*/

/*
Intution: 
			Here the left value will be the least possible value i.e. 1 or the least value in the array...

			and the right value is the maximum possible value i.e. the max value in the array.....

			then we have to find the medium of left and right and check weather it is the correct value or not....

			and then have to update the answer with the medium value...... 
*/
class Solution 
{
    public int minimumSize(int[] nums, int mop) 
    { 
        int l=1;
        int r=Integer.MIN_VALUE;
        for(int i : nums)
        {
            l=Math.min(l,i);
            r=Math.max(r,i);
        }
        
        int ans=r;
        while(l<=r)
        {
            int mid=(r-l)/2 + l;
            if(mid==0) continue;
            if(check(nums,mop,mid)==true)
            {
                ans=Math.min(ans,mid);
                r=mid-1;
            }
            else l=mid+1;
        }
        
        return ans;
    }
    
    public boolean check(int[] nums,int mop,int val)
    {
        int cnt=0;
        for(int i=0;i<nums.length;++i)
        {
            if(nums[i]>val)
            {
                cnt=cnt+(int)Math.ceil((double)nums[i]/(double)val)-1;
            }
        }
        if(cnt>mop) return false;
        else return true;
    }
}