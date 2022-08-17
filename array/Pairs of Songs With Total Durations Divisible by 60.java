/*
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
*/

/*
Intution:
			we have to traverse the array and check the map if it coontains and value that make the current value divisible by 60....

			if yes we increase the ans by the frequency of that element in the map....

			we should put the i%60 value in the map as all value which have the same value on % by 60 will have the same influence on the upcoming ith value......
*/

class Solution 
{
    public int numPairsDivisibleBy60(int[] time) 
    {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i : time)
        {
            if(i%60==0)
            {
                if(map.containsKey(0)) ans+=map.get(0);
            }
            else
            {
                if(map.containsKey(60-(i%60))) ans+=map.get(60-(i%60));
            }
            
            map.put(i%60,map.getOrDefault(i%60,0)+1);
        }
        
        return ans;
    }
}