import java.util.*;
/*
You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

Return a list answer of size 2 where:

answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.

Note:

You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
 */
class Solution 
{
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(int[] val : matches)
        {
            map.put(val[1],map.getOrDefault(val[1],0)+1);
        }

        List<Integer> l1=new ArrayList<>();
        for(Map.Entry<Integer,Integer> i : map.entrySet())
        {
            if(i.getValue()==1) l1.add(i.getKey());
        }
        List<Integer> l2=new ArrayList<>();
        for(int[] val : matches)
        {
            if(!map.containsKey(val[1])) l2.add(val[1]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        Collections.sort(l1);
        Collections.sort(l2);
        ans.add(l2);
        ans.add(l1);

        return ans;
    }
}