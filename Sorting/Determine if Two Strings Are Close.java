/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise. 

"abbzzca"
"babzzcz"
Output: false

"aaabbbbccddeeeeefffff"
"aaaaabbcccdddeeeeffff"
Output: false
*/

import java.util.*;

class Solution 
{
    public boolean closeStrings(String word1, String word2) 
    {
        int[] hash1=new int[26];
        int[] hash2=new int[26];

        for(int i=0;i<word1.length();++i)
        {
            ++hash1[word1.charAt(i)-'a'];
        }

        for(int i=0;i<word2.length();++i)
        {
            ++hash2[word2.charAt(i)-'a'];
        }
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();

        for(int i=0;i<26;++i)
        {
            if((hash1[i]==0 && hash2[i]!=0) || (hash1[i]!=0 && hash2[i]==0)) return false;

            map1.put(hash1[i],map1.getOrDefault(hash1[i], 0));
            map2.put(hash2[i],map2.getOrDefault(hash2[i], 0));
        }
        if(map1.size()!=map2.size()) return false;

        for(Map.Entry<Integer,Integer> i : map1.entrySet())
        {
            if(!map2.containsKey(i.getKey())) return false;
            else
            {
                if(map2.get(i.getKey())!=i.getValue()) return false;
            }
        }

        return true;
    }    
}