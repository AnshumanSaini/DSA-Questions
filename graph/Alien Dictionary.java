/*
Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.
 

Example 1:

Input: 
N = 5, K = 4
dict = {"baa","abcd","abca","cab","cad"}
Output:
1
Explanation:
Here order of characters is 
'b', 'd', 'a', 'c' Note that words are sorted 
and in the given language "baa" comes before 
"abcd", therefore 'b' is before 'a' in output.
Similarly we can find other orders.
Example 2:

Input: 
N = 3, K = 3
dict = {"caa","aaa","aab"}
Output:
1
Explanation:
Here order of characters is
'c', 'a', 'b' Note that words are sorted
and in the given language "caa" comes before
"aaa", therefore 'c' is before 'a' in output.
Similarly we can find other orders.
*/

import java.util.*;

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> tra=new ArrayList<>();
        
        for(int i=0;i<K;++i)
        {
            tra.add(new ArrayList<Integer>());
        }

        int[] indegree=new int[K];
        for(int i=0;i<N-1;++i)
        {
            int j=0;
            while(j<dict[i].length() && j<dict[i+1].length())
            {
                char ch1=dict[i].charAt(j);
                char ch2=dict[i+1].charAt(j);
                //System.out.print(ch1+" "+ch2+"........");
                if(ch1!=ch2)
                {
                    //System.out.println("............");
                    tra.get(ch1-'a').add(ch2-'a');
                    ++indegree[ch2-'a'];
                    break;
                }
                ++j;
            }
            //System.out.println();
        }

        StringBuilder sb=new StringBuilder("");
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<K;++i) 
        {
            //System.out.print(indegree[i]+" ");
            if(indegree[i]==0) q.add(i);
        }
        //System.out.println();

        while(!q.isEmpty())
        {
            Integer hld=q.poll();
            for(Integer val : tra.get(hld))
            {
                --indegree[val];
                if(indegree[val]==0) q.add(val);
            }
            sb.append((char)(hld+'a'));
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}