/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.
*/

/*
Intution: 
			we can divide the problem into subparts if we are able to compute the problem from the last step to the starting step.....

			let there are baloons [1	2	3	4] so , let the ballon 3 burst at the last then at second last step the ballons could be
			{[1,3]	,[2,3]	,[3,4]} and the same logic is used for the next above steps....

			we have to insert 1 at the end and start of the array...

			we can compute the cost with (arr[i-1]*arr[ind]*arr[j+1]) and then the subarray will be solve(i,ind-1) and solve(ind+1,j) 
*/

class Solution 
{
    public int solve(List<Integer> list,int i,int j,int[][] dp)
    {
        if(i>j) return 0;
        int ans=Integer.MIN_VALUE;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        for(int k=i;k<=j;++k)
        {
            int cost=(list.get(i-1)*list.get(k)*list.get(j+1))+solve(list,k+1,j,dp)+solve(list,i,k-1,dp);
            ans=Math.max(ans,cost);
        }
        
        return dp[i][j]=ans;
    }
    public int maxCoins(int[] nums) 
    {
        List<Integer> list=new ArrayList<>();
        
        list.add(1);
        for(int i : nums) list.add(i);
        list.add(1);
        int[][] dp=new int[list.size()][list.size()];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(list,1,list.size()-2,dp);
    }
} 