/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
*/

/*
Intution:
			Here we have assume all words in the wordList as a node and the beginWord as the starting node and endWord as the destination node...

			and we have to find the minimum distance between the startNode and the destination node...

			for finding the minimum distance we have to use the BFS algorithm.... 
*/

class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Queue<String> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        int depth=0;
        for(String str : wordList)
        {
            if(str.equals(endWord)) depth=1;
            
            set.add(str);
        }
        
        if(depth!=1) return 0;
        
        q.add(beginWord);
        
        while(!q.isEmpty())
        {
            
            int size=q.size();
            for(int j=0;j<size;++j)
            {
                String hld=q.poll();
                if(hld.equals(endWord)) return depth;
                for(int i=0;i<hld.length();++i)
                {
                    char[] tmp=hld.toCharArray();
                    for(char ch='a';ch<='z';++ch)
                    {
                        tmp[i]=ch;
                        
                        String str=new String(tmp);
                        
                        if(hld.equals(str)) continue;
                        
                        if(set.contains(str))
                        {
                            q.add(str);
                            set.remove(str);
                        }
                    }
                }
            }
            
            ++depth;
        }
        
        return 0;
    }
}