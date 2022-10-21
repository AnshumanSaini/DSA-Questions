/*
You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

num consists of the digits '1' to '9', where each digit is used at most once.
If pattern[i] == 'I', then num[i] < num[i + 1].
If pattern[i] == 'D', then num[i] > num[i + 1].
Return the lexicographically smallest possible string num that meets the conditions.
*/

/*
Intution:
			we have to reverse the number till we have encounter the 'D' letter....
*/

class Solution 
{
    public void reverse(int[] arr,int s,int e)
    {
        while(s<e)
        {
            int tmp=arr[s];
            arr[s]=arr[e];
            arr[e]=tmp;
            ++s;
            --e;
        }
    }
    public String smallestNumber(String pattern) 
    {
        StringBuilder ans=new StringBuilder("");
        int n=pattern.length();

        int[] arr=new int[n+1];
        for(int i=0;i<=n;++i)
        {
            arr[i]=i+1;
        }

        for(int i=0;i<n;++i)
        {
            if(pattern.charAt(i)=='D')
            {
                int s=i;
                while(i<n && pattern.charAt(i)=='D') ++i;
                int e=i;
                reverse(arr,s,e);
            }
        }

        for(int i=0;i<=n;++i) ans.append(Integer.toString(arr[i]));

        return ans.toString();      
    }
}