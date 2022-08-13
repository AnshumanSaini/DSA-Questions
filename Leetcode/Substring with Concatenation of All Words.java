/*
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.
*/

/*
Intution: 
			we need two HashMap here one for storing the words data with frequency and another for storing the visited string...

			we will traverse the i value till s.length()-(sizeof words[] * sizeof single element in the words array)...

			if the ith word is present in the map we will put it in the visited map and if by any chance the frequency of element in visited map is more than the frequency in the map then we break from the loop....
*/

class Solution 
{
    public List<Integer> findSubstring(String s, String[] words) 
    {
        if(s.length()==0 || words.length==0) return new ArrayList<Integer>();
        
        List<Integer> ans=new ArrayList<>();
        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String str : words) map.put(str,map.getOrDefault(str,0)+1);
        
        int n=words.length;
        int size=words[0].length();
        for(int i=0;i<=(s.length()-n*size);++i)
        {
            HashMap<String,Integer> seenMap=new HashMap<>();
            for(int j=0;j<n;++j)
            {
                int startIndex=i+j*size;
                
                String str=s.substring(startIndex,startIndex+size);
                
                if(!map.containsKey(str)) break;
                
                seenMap.put(str,seenMap.getOrDefault(str,0)+1);
                
                if(seenMap.get(str)>map.get(str)) break;
                
                if((j+1)==n) ans.add(i);
            }
        }
        
        return ans;
    }
}