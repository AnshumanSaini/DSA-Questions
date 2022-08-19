/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.
*/

/*
Intution: 
			we have to partition the array, let the array be "abba".....

			so at step one we should partition the first index and send the part of the string to recursion...

			we should traverse the string and should find weather it is palindrome or not if it is palindrome, then add the substring to the list and send the rest of the string to the recursion....
*/
class Solution 
{
    public List<List<String>> partition(String s) 
    {
        List<String> list=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        
        solve(s,0,list,ans);
        
        return ans;
    }    
    
    public void solve(String s,int ind,List<String> list,List<List<String>> ans)
    {
        if(ind==s.length())
        {
            ans.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i=ind;i<s.length();++i)
        {
            if(isPalindrome(s,ind,i))
            {
                list.add(s.substring(ind,i+1));
                solve(s,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end)) return false;
            ++start;
            --end;
        }
        
        return true;
    }
}