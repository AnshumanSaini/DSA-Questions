/*
Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
    			
    			0	1	2	3	4	5	6

Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.
*/

/*
Intution:
			for divide and conqure we have to first sort the cuts array so that any ith cut should not affect the jth cut....

			now to count the length of the stick at any particular cut we have to add 0 and length of the stick at the front and end of the stick respectively....

			now we just have implement the MCM technique in the cuts array as follows....
*/
class Solution 
{
    public int solve(List<Integer> list,int i, int j,int[][] dp)
    {
        if(i>j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        int min=(int)Math.pow(10,9);
        int k=i;
        while(k<=j)
        {
            min=Math.min(min,list.get(j+1)-list.get(i-1)+solve(list,i,k-1,dp)+solve(list,k+1,j,dp));
            ++k;
        }
        
        return dp[i][j]=min;
    }
    public int minCost(int n, int[] cuts) 
    {
        Arrays.sort(cuts);
        List<Integer> list=new ArrayList<>();
        
        list.add(0);
        for(int i : cuts) list.add(i);
        list.add(n);
        int[][] dp=new int[list.size()][list.size()];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(list,1,list.size()-2,dp);
    }
}