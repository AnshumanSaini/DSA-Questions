/*
We have an array of integers, nums, and an array of requests where requests[i] = [starti, endi]. The ith request asks for the sum of nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.

Return the maximum total sum of all requests among all permutations of nums.

Since the answer may be too large, return it modulo 109 + 7.
*/

/*
In the questions of given ranges of the values like [1 to 2], [2 to 4], [5 to 8],...

and we have to count the number of times every number occur in every range we can use the following way: 

count[] = new int[n];
for (int[] r: req) 
{
    count[r[0]] += 1;
    if (r[1] + 1 < n)
        count[r[1] + 1] -= 1;
}
    for (int i = 1; i < n; ++i)
        count[i] += count[i - 1];
*/

class Solution 
{
    public int maxSumRangeQuery(int[] nums, int[][] requests) 
    {
        int n=nums.length;
        int[] count=new int[n];
        
        for(int[] req : requests)
        {
            ++count[req[0]];
            if(req[1]+1<n) --count[req[1]+1];
        }
        
        for(int i=1;i<n;++i)
        {
            count[i]+=count[i-1];
        }
        
        Arrays.sort(nums);
        Arrays.sort(count);
        long sum=0;
        for(int i=0;i<n;++i)
        {
            sum+=((long)nums[i]*count[i]);
        }
        
        return (int)(sum%1000000007);
    }
}
