/*
We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.
*/

/*
Intution:
 			we have to update the array by making the numbers greater than 8 to be 1 and the number less than or equal to 8 to be -1.

 			then we have to use the same logic as the "subarray sum equlas to k".

*/

class Solution 
{
    public int longestWPI(int[] hours) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=hours.length;
        for(int i=0;i<n;++i)
        {
            if(hours[i]>8) hours[i]=1;
            else hours[i]=-1;
        }
        int sum=0;
        int ans=0;
        map.put(0,-1);
        for(int i=0;i<n;++i)
        {
            sum+=hours[i];
            if(!map.containsKey(sum))
            {
                map.put(sum,i);
            }

            if(sum>0) ans=i+1;
            else
            {
                if(map.containsKey(sum-1)) ans=Math.max(ans,i-map.get(sum-1));
            }
        }

        return ans;
    }
}