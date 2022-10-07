/*
A wonderful string is a string where at most one letter appears an odd number of times.

For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.
*/

/*
Intution:
			same as the "Subarray sum equals K"....

			but to record the 10 numbers even/odd status we have to use the bit manipulations.....
*/

class Solution 
{
    public long wonderfulSubstrings(String word) 
    {
        HashMap<Long,Integer> map=new HashMap<>();
        long mask=0;
        long ans=0;
        map.put(0l,1);
        for(int i=0;i<word.length();++i)
        {
            char ch=word.charAt(i);
            mask=mask^(1<<(ch-'a'));
            ans+=map.getOrDefault(mask,0);

            for(int j=0;j<10;++j)
            {
                ans+=map.getOrDefault(mask^(1<<j),0);
            }

            map.put(mask,map.getOrDefault(mask,0)+1);
        }

        return ans;    
    }
}