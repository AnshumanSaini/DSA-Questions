/*
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
*/

/*
Intution:
			we have to define the left most and right most value and check the mid value as the answer and keep on decreasing the range until we find the correct answer......
*/

class Solution 
{
    public int minDays(int[] arr, int m, int k) 
    {
        int n=arr.length;
        int req=m*k;
        if(req>n) return -1;
        
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i : arr)
        {
            l=Math.min(i,l);
            r=Math.max(i,r);
        }
        
        int ans=r;
        while(l<=r)
        {
            int mid=(r-l)/2 + l;
            if(solve(mid,arr,m,k))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        
        return ans;
    }
    
    public boolean solve(int val,int[] arr,int m,int k)
    {
        int sum=0;
        for(int i : arr)
        {
            if(sum==k)
            {
                sum=0;
                --m;
            }
            if(m==0) break;
            
            if(i>val) sum=0;
            else ++sum;
        }
        if(sum==k) --m;
        
        return m==0;
    }
}