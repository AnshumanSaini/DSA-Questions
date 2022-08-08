//Longest Increasing subsequesnce............

// start from last and use two pointers one for current ans the another for storing the index of the previous value.

//if the current is greater then the previous value then don't take that value.
// else there are two cases weather to take that value or nottake that value...

class Solution 
{
    public int solve(int curr,int prev,int[] arr,int[][] dp)
    {
        if(curr<0)
        {
            return 0;
        }
        if(dp[curr][prev]!=-1) return dp[curr][prev];
       
        if(prev==arr.length || arr[prev]>arr[curr])
        {
            return dp[curr][prev]=Math.max(1+solve(curr-1,curr,arr,dp),solve(curr-1,prev,arr,dp));
        }
        else return dp[curr][prev]=solve(curr-1,prev,arr,dp);
    }
    public int lengthOfLIS(int[] arr) 
    {
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return solve(n-1,n,arr,dp);
    }
}