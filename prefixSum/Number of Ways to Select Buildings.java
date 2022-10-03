/*
You are given a 0-indexed binary string s which represents the types of buildings along a street where:

s[i] = '0' denotes that the ith building is an office and
s[i] = '1' denotes that the ith building is a restaurant.
As a city official, you would like to select 3 buildings for random inspection. However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.

For example, given s = "001101", we cannot select the 1st, 3rd, and 5th buildings as that would form "011" which is not allowed due to having two consecutive buildings of the same type.
Return the number of valid ways to select 3 buildings.
*/

*/
Intution:
			there can be only two types of subsequences 101 & 010....

			for any value i.e. for any current value the possible number of subsequences are no of reverse value to its right * no of reverse value to its left.....

/*

class Solution 
{
    public long numberOfWays(String s) 
    {
        int n=s.length();
        int[] cnt=new int[2];
        for(int i=0;i<n;++i)
        {
            ++cnt[s.charAt(i)-'0'];
        }
        long ans=0l;
        int[] curr=new int[2];
        for(int i=0;i<n;++i)
        {
            int val=s.charAt(i)-'0';
            int reverse=0;
            if(val==0) reverse=1;

            ans+=((long)(curr[reverse]*(cnt[reverse]-curr[reverse])));

            ++curr[val];
        }

        return ans;
    }
}