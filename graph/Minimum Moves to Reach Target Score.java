/*
You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.

In one move, you can either:

Increment the current integer by one (i.e., x = x + 1).
Double the current integer (i.e., x = 2 * x).
You can use the increment operation any number of times, however, you can only use the double operation at most maxDoubles times.

Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target starting with 1.
*/

import java.util.*;

class Solution 
{
    public int minMoves(int target, int maxDoubles) 
    {
        int ans=0;
        while(target>1 && maxDoubles>0)
        {
            if(target%2==0)
            {
                --maxDoubles;
                target>>=1;
                ++ans;
            }
            else
            {
                target--;
                ++ans;
            }
        }
        
        return ans+(target-1);
    }
}