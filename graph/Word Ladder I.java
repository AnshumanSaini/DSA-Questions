/*
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.

Note: If no possible way to transform sequence from startWord to targetWord return 0
*/

import java.util.*;

class Pair
{
    String val;
    int level;

    public Pair(String val, int level)
    {
        this.val=val;
        this.level=level;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        
        for(String s : wordList) set.add(s);

        set.remove(startWord);
        q.add(new Pair(startWord, 1));

        while(!q.isEmpty())
        {
            Pair hld=q.poll();
            if(hld.val.equals(targetWord)) return hld.level;
            char[] ch=hld.val.toCharArray();

            for(int i=0;i<ch.length;++i)
            {
                int j=0;
                char tmp=ch[i];
                while(j<26)
                {
                    ch[i]=(char)('a'+j);
                    String curr=new String(ch);
                    if(set.contains(curr))
                    {
                        set.remove(curr);
                        q.add(new Pair(curr, hld.level+1));
                    }
                    ++j;
                }
                ch[i]=tmp;
            }
        }

        return 0;
    }
}