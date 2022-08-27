/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
*/

/*
Intution:
			start traversing the array and keep on increasing the frequency of the elements in the string in an array.....

			keep storing the element with the highest frequency because the window range - the max frequency will give the to_be_deleated elements and if those elements count increases by k then decrease the freuency of the element at start index and increament start pointer....
*/

class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int[] hash=new int[26];
        int max=0;
        int ans=0;
        int j=0;
        for(int i=0;i<s.length();++i)
        {
            
            max=Math.max(max,++hash[s.charAt(i)-'A']);
            if((i-j+1-max)>k)
            {
                --hash[s.charAt(j)-'A'];
                ++j;
            }
            ans=Math.max(ans,i-j+1);
        }
        
        return ans;
    }
}